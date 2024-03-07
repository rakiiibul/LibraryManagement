package com.raikibulhasan.librarymanagement.htmlController;

import com.raikibulhasan.librarymanagement.model.Book;
import com.raikibulhasan.librarymanagement.model.User;
import com.raikibulhasan.librarymanagement.repository.BookRepository;
import com.raikibulhasan.librarymanagement.repository.UserRepository;
import com.raikibulhasan.librarymanagement.service.BookService;
import com.raikibulhasan.librarymanagement.service.BookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@Controller
public class PageController { //
     public String id;
//
      @Autowired
      private UserRepository userRepository;
      @Autowired
      private BookRepository bookRepository;
      @Autowired
      private BookService bookService;



    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/addedBook")
    public String addBook(@ModelAttribute Book book, Model model){

        System.out.println(book.toString());
        bookRepository.save(book);
        return "home";
    }
    @PostMapping("/nice")
    public String userRegistration(@ModelAttribute User user, Model model){
        System.out.println(user.toString());
        User user_registered=userRepository.save(user);
        model.addAttribute("fname",user.getFname());
        return "view";
     }

    @PostMapping("/login")
    public String viewmodel(int page,Model model){
        int pageSize = 10; // Number of books per page
        Page<Book> bookPage = bookService.getBooksPage(PageRequest.of(page, pageSize));
        List<Book> books = bookPage.getContent();
        model.addAttribute("books", books);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", bookPage.getTotalPages());


       List<Book> bookList=(List<Book>) bookService.getBooks();
        model.addAttribute("books", bookList.isEmpty()? Collections.EMPTY_LIST:bookList);
        return "view";
    }
    @RequestMapping("/home")
    public String homePage(Model model){
        return viewmodel(model);
    }
    @RequestMapping("/searchpage")
    public String searchPage(Model model){
        return "searchPage";
    }
    @GetMapping("/books")
    public String showBooks() {
        return "view";
    }

    @GetMapping("/books/search")
    @ResponseBody
    public List<Book> searchBooksByTitle(@RequestParam("title") String title) {
        return bookService.searchBooksByTitle(title);

    }




    @PostMapping("/signedup")
    public String userlogin(@ModelAttribute User user,Model model){
        //System.out.println(user.toString());
//        eid= String.valueOf(userRepository.findById("therakiiibul@outlook.com"));
//        System.out.println("eid: "+eid);

        // User user_registered=userRepository.save(user);

        return "AddBook";
    }
        @RequestMapping("/schedulerPage")
        public String scheduler(@ModelAttribute User user,Model model){
        //System.out.println(user.toString());
        //eid= String.valueOf(userRepository.findById("therakiiibul@outlook.com"));
        //System.out.println("eid: "+eid);

        // User user_registered=userRepository.save(user);
        //model.addAttribute("fname",user.getFname());
        return "schedule";
    }

}

