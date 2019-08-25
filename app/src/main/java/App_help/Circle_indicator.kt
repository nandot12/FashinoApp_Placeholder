package App_help

import android.content.Context
import android.os.Handler
import android.support.v4.view.ViewPager
import android.widget.ImageView


/**
 * Created by VAIO on 5/2/2017.
 */

class Circle_indicator {
    internal lateinit var rr: Runnable
    internal var i: Int = 0
    internal var handler = Handler()

    fun circle_indicator(context: Context, viewPager: ViewPager, imageView: List<ImageView>) {
        /* for(int i=0;i<imageView.size();i++){
           switch (i){
               case 0:
                   imageView.get(0).setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           imageView.get(0).setImageResource(R.drawable.circle_indicator_selected);
                           viewPager.setCurrentItem(0);
                       }
                   });
                   break;
               case 1:
                   imageView.get(1).setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           imageView.get(1).setImageResource(R.drawable.circle_indicator_selected);
                           viewPager.setCurrentItem(1);
                       }
                   });
                   break;
               case 2:
                   imageView.get(2).setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           imageView.get(2).setImageResource(R.drawable.circle_indicator_selected);
                           viewPager.setCurrentItem(2);
                       }
                   });
                   break;

           }

       }

       viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrollStateChanged(int position) {
           }

           @Override
           public void onPageScrolled(int arg0, float arg1, int arg2) {
           }

           @Override
           public void onPageSelected(int position) {
               // TODO Auto-generated method stub
               for(int i=0;i<imageView.size();i++){
                   imageView.get(i).setImageResource(R.drawable.circle_indicator);
                                 }
               btnAction(position);
           }

           public void btnAction(int action) {

                   for (int i = 0; i < imageView.size(); i++) {
                       switch (action) {
                       case 0:
                           imageView.get(0).setImageResource(R.drawable.circle_indicator_selected);
                           break;
                       case 1:
                           imageView.get(1).setImageResource(R.drawable.circle_indicator_selected);
                           break;
                       case 2:
                          imageView.get(2).setImageResource(R.drawable.circle_indicator_selected);
                           break;
                   }
               }
           }
       });*/
    }

    fun autoSlider(viewPager: ViewPager, imageview: Array<String>, context: Context) {

        rr = Runnable {
            val pos = viewPager.currentItem
            if (pos > i && pos != imageview.size - 1) {
                i = pos
                i++
            } else if (pos < i - 1) {
                i = pos
                i++
            }
            viewPager.setCurrentItem(i, true)
            i++
            if (i >= imageview.size)
                i = 0
            autoSlider(viewPager, imageview, context)
        }
        handler.postDelayed(rr, 3000)
    }
}
