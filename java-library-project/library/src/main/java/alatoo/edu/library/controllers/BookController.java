package alatoo.edu.library.controllers;

import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.dto.BookOperationDto;
import alatoo.edu.library.models.dto.SaveBookDto;
import alatoo.edu.library.models.dto.WalletDto;
import alatoo.edu.library.models.entities.BookOperation;
import alatoo.edu.library.models.input_dtos.InputBookDto;
import alatoo.edu.library.services.BookOperationService;
import alatoo.edu.library.services.BookService;
import alatoo.edu.library.services.SaveBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/books")
public class BookController implements BaseCrudController<BookDto,Long>{
    @Autowired
    private SaveBookService saveBookService;

    @Autowired
    private BookService service;

    @Autowired
    private BookOperationService bookOperationService;

//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/save-book")
    public ResponseEntity<InputBookDto> save(@RequestBody InputBookDto inputBookDto) {
        return new ResponseEntity<>(service.saveInputBookDto(inputBookDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BookDto> save(BookDto bookDto) {
        return null;
    }

    @Override
    public ResponseEntity<BookDto> update(BookDto bookDto) {
        return null;
    }

    @Override
    public ResponseEntity<BookDto> findById(Long id) {
        return null;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<BookDto>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/find-by-name/{name}")
    public ResponseEntity<List<BookDto>> findByName(@PathVariable String name){
        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/find-by-author/{author}")
    ResponseEntity<List<BookDto>> findByAuthor(@PathVariable String author){
        return new ResponseEntity<>(service.findByAuthor(author), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/find-by-publishing-date/{publishingDate}")
    ResponseEntity<List<BookDto>> findByPublishingDate(@PathVariable int publishingDate){
        System.out.println(publishingDate);
        return new ResponseEntity<>(service.findByPublishingDate(publishingDate), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/find-books-read-by-user/{readerId}")
    ResponseEntity<List<BookDto>> alreadyReadBooks(@PathVariable Long readerId){
        System.out.println(readerId);
        return new ResponseEntity<>(service.alreadyReadBooks(readerId), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/find-favourite-books/{readerId}")
    ResponseEntity<List<BookDto>> favouriteBooks(@PathVariable Long readerId){
        return new ResponseEntity<>(service.findFavouriteBooks(readerId), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/mark-as-read/{readerId}/{bookId}")
    public ResponseEntity<SaveBookDto> markAsRead(@PathVariable Long readerId, @PathVariable Long bookId) {
        return new ResponseEntity<>(saveBookService.addBookToAlreadyRead(readerId, bookId), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/mark-as-favourite/{readerId}/{bookId}")
    public ResponseEntity<SaveBookDto> markAsFavourite(@PathVariable Long readerId, @PathVariable Long bookId) {
        return new ResponseEntity<>(saveBookService.addBookToFavourites(readerId, bookId), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/buy/{readerId}/{bookId}")
    public ResponseEntity<BookOperationDto> buyBook(@PathVariable Long readerId, @PathVariable Long bookId) {
        return new ResponseEntity<>(bookOperationService.buy_a_book(bookId, readerId), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/borrow/{readerId}/{bookId}/{endDate}")
    public ResponseEntity<BookOperationDto> borrowBook(@PathVariable Long readerId, @PathVariable Long bookId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return new ResponseEntity<>(bookOperationService.borrow_a_book(bookId, readerId, LocalDateTime.of(endDate, LocalTime.NOON)), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/return/{readerId}/{bookId}")
    public ResponseEntity<BookOperationDto> returnBook(@PathVariable Long readerId, @PathVariable Long bookId) {
        return new ResponseEntity<>(bookOperationService.returnBook(bookId, readerId), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/reserve/{readerId}/{bookId}/{endDate}")
    public ResponseEntity<BookOperationDto> reserveBook(@PathVariable Long readerId, @PathVariable Long bookId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return new ResponseEntity<>(bookOperationService.reserveBook(bookId, readerId, LocalDateTime.of(endDate, LocalTime.NOON)), HttpStatus.CREATED);
    }
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/set-up-wallet/{readerId}")
    ResponseEntity<WalletDto> setUpWallet(@PathVariable Long readerId){
        return new ResponseEntity<>(bookOperationService.walletAutomaticAdd(readerId), HttpStatus.OK);
    }
}
