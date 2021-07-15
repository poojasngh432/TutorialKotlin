package com.example.toolsdemoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.toolsdemoapp.R;
import com.example.toolsdemoapp.adapter.BooksAdapter;
import com.example.toolsdemoapp.model.Book;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import co.dift.ui.SwipeToAction;

public class SwipeToActionActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BooksAdapter adapter;
    SwipeToAction swipeToAction;

    List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // facebook image library
        Fresco.initialize(this);

        setContentView(R.layout.activity_swipe_to_action);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new BooksAdapter(this.books);
        recyclerView.setAdapter(adapter);

        swipeToAction = new SwipeToAction(recyclerView, new SwipeToAction.SwipeListener<Book>() {
            @Override
            public boolean swipeLeft(final Book itemData) {
                final int pos = removeBook(itemData);
                displaySnackbar(itemData.getTitle() + " removed", "Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addBook(pos, itemData);
                    }
                });
                return true;
            }

            @Override
            public boolean swipeRight(Book itemData) {
                displaySnackbar(itemData.getTitle() + " loved", null, null);
                return true;
            }

            @Override
            public void onClick(Book itemData) {
                displaySnackbar(itemData.getTitle() + " clicked", null, null);
            }

            @Override
            public void onLongClick(Book itemData) {
                displaySnackbar(itemData.getTitle() + " long clicked", null, null);
            }
        });


        populate();

        // use swipeLeft or swipeRight and the elem position to swipe by code
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToAction.swipeRight(2);
            }
        }, 3000);
    }

    private void populate() {
        this.books.add(new Book("The Guernsey Literary and Potato Peel Pie Society", "Mary Ann Shaffer, Annie Barrows", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1529026760l/39832183.jpg"));
        this.books.add(new Book("All the Light We Cannot See", "Anthony Doerr", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1451445646l/18143977.jpg"));
        this.books.add(new Book("Tesla: Inventor of the Electrical Age", "W. Bernard Carlson", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1416180837l/17130499.jpg"));
        this.books.add(new Book("Orwell's Revenge: The \"1984\" Palimpsest", "Peter Huber", "https://images-na.ssl-images-amazon.com/images/I/51g7NA3v26L._SX331_BO1,204,203,200_.jpg"));
        this.books.add(new Book("How to Lie with Statistics", "Darrell Huff", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1427665814l/51291.jpg"));
        this.books.add(new Book("Abundance: The Future Is Better Than You Think", "Peter H. Diamandis, Steven Kotler", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1344396582l/13187824.jpg"));
        this.books.add(new Book("Where Good Ideas Come From", "Steven Johnson", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1311705993l/8034188.jpg"));
        this.books.add(new Book("The Information: A History, A Theory, A Flood", "James Gleick", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1348046486l/8701960.jpg"));
        this.books.add(new Book("Turing's Cathedral: The Origins of the Digital Universe", "George Dyson", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1322700777l/12625589.jpg"));
        this.books.add(new Book("Dreaming in Code: Two Dozen Programmers, Three Years, 4,732 Bugs, and One Quest for Transcendent Software", "Scott Rosenberg", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1442376721l/32475._SY475_.jpg"));
        this.books.add(new Book("Where Wizards Stay Up Late: The Origins of the Internet", "Katie Hafner ", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1405259838l/281818.jpg"));
        this.books.add(new Book("The Testaments", "Margaret Atwood", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1549292344l/42975172.jpg"));
        this.books.add(new Book("The Five: The Untold Lives of the Women Killed by Jack the Ripper", "Hallie Rubenhold", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1519263139l/37570548._SY475_.jpg"));
        this.books.add(new Book("Pumpkinheads", "Rainbow Rowell, Faith Erin Hicks", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1537541596l/40864790.jpg"));
        this.books.add(new Book("Five Feet Apart", " Rachael Lippincott, Mikki Daughtry, Tobias Iaconis", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1534693322l/38926328.jpg"));
    }

    private void displaySnackbar(String text, String actionName, View.OnClickListener action) {
        Snackbar snack = Snackbar.make(findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG)
                .setAction(actionName, action);

        View v = snack.getView();
        v.setBackgroundColor(getResources().getColor(R.color.secondary));
        ((TextView) v.findViewById(com.google.android.material.R.id.snackbar_text)).setTextColor(Color.WHITE);
        ((TextView) v.findViewById(com.google.android.material.R.id.snackbar_action)).setTextColor(Color.BLACK);

        snack.show();
    }

    private int removeBook(Book book) {
        int pos = books.indexOf(book);
        books.remove(book);
        adapter.notifyItemRemoved(pos);
        return pos;
    }

    private void addBook(int pos, Book book) {
        books.add(pos, book);
        adapter.notifyItemInserted(pos);
    }
}
