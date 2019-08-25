package App_help

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint



/**
 * Created by VAIO on 5/12/2017.
 */

class Apphelper {
//    fun transformtocircle(source: Bitmap, context: Context): Bitmap {
//        val bitmap: Bitmap
//        try {
//
//            val size = Math.min(source.width, source.height)
//
//            val x = (source.width - size) / 2
//            val y = (source.height - size) / 2
//
//            val squaredBitmap = Bitmap
//                    .createBitmap(source, x, y, size, size)
//            if (squaredBitmap != source) {
//                // source.recycle();
//            }
//            bitmap = Bitmap.createBitmap(size, size,
//                    squaredBitmap.config)
//
//            val canvas = Canvas(bitmap)
//            val paint = Paint()
//            val shader = BitmapShader(squaredBitmap,
//                    BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP)
//            paint.shader = shader
//            paint.isAntiAlias = true
//
//            val r = size / 2f
//            canvas.drawCircle(r, r, r, paint)
//            // canvas.drawArc(rectf, -90, 360, false, lightRed);
//            // squaredBitmap.recycle();
//            return bitmap
//        } catch (e: Exception) {
//            // TODO: handle exception
//        }
//
//        return BitmapFactory.decodeResource(context.resources,
//                R.mipmap.ic_launcher)
//    }
}
