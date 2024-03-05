package com.raikibulhasan.librarymanagement.htmlController;

import com.raikibulhasan.librarymanagement.model.Book;
import com.raikibulhasan.librarymanagement.model.User;
import com.raikibulhasan.librarymanagement.repository.BookRepository;
import com.raikibulhasan.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController { //
     public String id;
//
      @Autowired
      private UserRepository userRepository;
      @Autowired
      private BookRepository bookRepository;


    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/addedBook")
    public String addBook(@ModelAttribute Book book, Model model){

        System.out.println(book.toString());
//        eid= String.valueOf(userRepository.findById("therakiiibul@outlook.com"));
//        System.out.println("eid: "+eid);

        //book.setAuthor("Raikibul Hasan");
        bookRepository.save(book);

        // User user_registered=userRepository.save(user);
        //model.addAttribute("fname",user.getFname());
        return "home";
    }
    @PostMapping("/nice")
    public String userRegistration(@ModelAttribute User user, Model model){
        System.out.println(user.toString());
        User user_registered=userRepository.save(user);
        model.addAttribute("fname",user.getFname());
        return "view";
     }



    @PostMapping("/signedin")
    public String userlogin(@ModelAttribute User user,Model model){
        //System.out.println(user.toString());
//        eid= String.valueOf(userRepository.findById("therakiiibul@outlook.com"));
//        System.out.println("eid: "+eid);

        // User user_registered=userRepository.save(user);
        //model.addAttribute("fname",user.getFname());
        return "view";
    }


}
//    @RequestMapping("/schedulerPage")
//    public String scheduler(@ModelAttribute User user,Model model){
//        //System.out.println(user.toString());
//        //eid= String.valueOf(userRepository.findById("therakiiibul@outlook.com"));
//        //System.out.println("eid: "+eid);
//
//        // User user_registered=userRepository.save(user);
//        //model.addAttribute("fname",user.getFname());
//        return "schedule";
//    }

//}