package com.imastudio.remmss.fashinoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class WishlistEmptyActivity : AppCompatActivity() {
    internal var toolbar: Toolbar? = null
    internal var toolbarback: ImageView? = null
    internal var toolbartext: TextView? = null
    internal var viewall: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist_empty)
        //   viewall = (TextView)findViewById(R.id.textview_regular33);
        //settoolbar();

    }

    /*    private void settoolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar1);;
        toolbarback=(ImageView) findViewById(R.id.back_arrow);
        toolbartext=(TextView) findViewById(R.id.toolbartext);

        toolbarback.setVisibility(View.GONE);
        toolbartext.setText("Wishlist");

    }*/
}
