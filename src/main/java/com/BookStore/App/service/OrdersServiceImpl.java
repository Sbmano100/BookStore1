package com.BookStore.App.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BookStore.App.Repository.BookRepository;
import com.BookStore.App.Repository.InventoryRepository;
import com.BookStore.App.Repository.OrdersRepository;
import com.BookStore.App.Repository.UserRepository;
import com.BookStore.App.exception.BookException;
import com.BookStore.App.exception.UserException;
import com.BookStore.App.model.book;
import com.BookStore.App.model.inventory;
import com.BookStore.App.model.orders;
import com.BookStore.App.model.user;

@Service
@Transactional
public class OrdersServiceImpl {

	@Autowired
	private OrdersRepository ordrepo;
	@Autowired
	private BookRepository brepo;
	@Autowired
	private UserRepository urepo;
	@Autowired
	private InventoryRepository irepo;
	@Autowired
	private UserService us;
	@Autowired
	private BookService bs;
	@Autowired
	private InventoryService is;
	
	
	public orders bookorder(orders order) {
		Optional<user> userdetails=this.urepo.findById(order.getUserid());
		Optional<book> bookdetails=this.brepo.findById(order.getBookid());
		Optional<inventory> invdetails=this.irepo.findById(order.getBookid());
		if(userdetails.isPresent()) {
			user userobj=userdetails.get();
			book bookobj=bookdetails.get();
			inventory invobj=invdetails.get();
			if(userobj.getBalance()<(0.2*bookobj.getPrice())) {
				throw new UserException("You don't have enough balance to rent a book");
			}
			else {
				if(invobj.getAvailability()<=0)
					throw new BookException("Out of stock");
				else {
					List<orders> user=this.ordrepo.findnoofusers(userobj.getUserid());
					if(user.size()>3)
						throw new UserException("You already rented maximum no of books");
					else {
						for(orders i:user) {
							long bookid=i.getBookid();
							if(bookid==bookobj.getBookid()&&i.getDateofReturn()==null)
								throw new UserException("You have already purchased the book");
						}
						this.us.deductmoney(userobj.getUserid(),bookobj.getPrice()*0.2);
						this.is.rentbook(bookobj.getBookid());
					}
				}
			}
		}
	
	return this.ordrepo.save(order);
  }
}

