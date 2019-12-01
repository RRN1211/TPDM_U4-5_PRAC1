package mx.edu.ittepic.tpdm_u4_5_prac1

import android.graphics.Canvas
import android.graphics.Paint
import android.provider.ContactsContract
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import mx.edu.ittepic.tpdm_u4_5_prac1.MainActivity

class Lienzo(p: MainActivity) : View(p) {
    val puntero = p
    var picono: Imagen ?= null

    //ICONOS A COLOR
    var fb_color = Imagen(this, -344f, 300f, R.drawable.fb_color)
    var insta_color = Imagen(this, 378f, 300f, R.drawable.insta_color)
    var twitter_color = Imagen(this, 1100f, 300f, R.drawable.twitter_color) //distancia entre figuras de 594 px
    var whats_color = Imagen(this, 1822f, 300f, R.drawable.whats_color)
    var youtube_color = Imagen(this, 2544f, 300f, R.drawable.youtube_color)
    //ICONOS B/N
    var fb_bn = Imagen(this, -344f, 300f, R.drawable.fb_bn)
    var insta_bn = Imagen(this, 378f, 300f, R.drawable.insta_bn)
    var twitter_bn = Imagen(this, 1100f, 300f, R.drawable.twitter_bn)
    var whats_bn = Imagen(this, 1822f, 300f, R.drawable.whats_bn)
    var youtube_bn = Imagen(this, 2544f, 300f, R.drawable.youtube_bn)
    //ICONOS VINTAGE
    var fb_vintage = Imagen(this, -344f, 300f, R.drawable.fb_vinta)
    var insta_vintage = Imagen(this, 378f, 300f, R.drawable.insta_vinta)
    var twitter_vintage = Imagen(this, 1100f, 300f, R.drawable.twitter_vinta)
    var whats_vintage = Imagen(this, 1822f, 300f, R.drawable.whats_vinta)
    var youtube_vintage = Imagen(this, 2544f, 300f, R.drawable.youtube_vinta)
    //ICONOS ANTIGUO
    var fb_antiguo = Imagen(this, -344f, 300f, R.drawable.fb_antiguo)
    var insta_antiguo = Imagen(this, 378f, 300f, R.drawable.insta_antiguo)
    var twitter_antiguo = Imagen(this, 1100f, 300f, R.drawable.twitter_antiguo)
    var whats_antiguo = Imagen(this, 1822f, 300f, R.drawable.whats_antiguo)
    var youtube_antiguo = Imagen(this, 2544f, 300f, R.drawable.youtube_antiguo)
    //Arreglo categorizando las imagenes
    var arrColor = arrayListOf<Imagen>(fb_color,insta_color,twitter_color,whats_color,youtube_color)
    var arrBn = arrayListOf<Imagen>(fb_bn,insta_bn,twitter_bn,whats_bn,youtube_bn)
    var arrVintage = arrayListOf<Imagen>(fb_vintage,insta_vintage,twitter_vintage,whats_vintage,youtube_vintage)
    var arrAntiguo = arrayListOf<Imagen>(fb_antiguo,insta_antiguo,twitter_antiguo,youtube_antiguo)

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        if (puntero.distancia == 0f){
            fb_color.invisible == false
            insta_color.invisible == false
            twitter_color.invisible == false
            whats_color.invisible == false
            youtube_color.invisible == false
            invalidate()
        }else{
            when (puntero.contShake){
                0 -> {
                    dibujarImgs(arrColor,c)
                    moverImgs(arrColor,puntero.x)
                }
                1 -> {
                    dibujarImgs(arrBn,c)
                    moverImgs(arrBn,puntero.x)
                }
                2 -> {
                    dibujarImgs(arrVintage,c)
                    moverImgs(arrVintage,puntero.x)
                }
                3 -> {
                    dibujarImgs(arrAntiguo,c)
                    moverImgs(arrAntiguo,puntero.x)
                }
            }
        }
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        when (e.action) {
            MotionEvent.ACTION_DOWN -> {
                //******************MENSAJES DE LOS ICONOS A COLOR********************
                if (fb_color.estaEnArea(e.getX(), e.getY()) || fb_bn.estaEnArea(e.getX(), e.getY()) || fb_vintage.estaEnArea(e.getX(), e.getY()) || fb_antiguo.estaEnArea(e.getX(), e.getY())) {
                    Toast.makeText(puntero, "Tocaste Facebook", Toast.LENGTH_SHORT)
                        .show()
                    picono = fb_color
                }
                if (insta_color.estaEnArea(e.getX(), e.getY()) || insta_bn.estaEnArea(e.getX(), e.getY()) || insta_vintage.estaEnArea(e.getX(), e.getY()) ||insta_antiguo.estaEnArea(e.getX(), e.getY())) {
                    Toast.makeText(puntero, "Tocaste Instagram", Toast.LENGTH_SHORT)
                        .show()
                    picono = insta_color
                }
                if (twitter_color.estaEnArea(e.getX(), e.getY()) || twitter_bn.estaEnArea(e.getX(), e.getY()) || twitter_vintage.estaEnArea(e.getX(), e.getY()) || twitter_antiguo.estaEnArea(e.getX(), e.getY())) {
                    Toast.makeText(puntero, "Tocaste Twitter", Toast.LENGTH_SHORT)
                        .show()
                    picono = twitter_color
                }
                if (whats_color.estaEnArea(e.getX(), e.getY()) || whats_bn.estaEnArea(e.getX(), e.getY()) || whats_vintage.estaEnArea(e.getX(), e.getY()) || whats_antiguo.estaEnArea(e.getX(), e.getY())) {
                    Toast.makeText(puntero, "Tocaste WhatsApp", Toast.LENGTH_SHORT)
                        .show()
                    picono = whats_color
                }
                if (youtube_color.estaEnArea(e.getX(), e.getY()) || youtube_bn.estaEnArea(e.getX(), e.getY()) || youtube_vintage.estaEnArea(e.getX(), e.getY()) || youtube_antiguo.estaEnArea(e.getX(), e.getY())) {
                    Toast.makeText(puntero, "Tocaste YouTube", Toast.LENGTH_SHORT)
                        .show()
                    picono = youtube_color
                }
            }
        }
        return true
    }
    fun moverImgs(arrayImagenes: ArrayList<Imagen>,x:Float){
        arrayImagenes.forEach {
            it.mover(x)
        }
        invalidate()
    }
    fun dibujarImgs(arrayImagenes: ArrayList<Imagen>,c:Canvas) {
        arrayImagenes.forEach {
            it.pintar(c)

        }
    }
}


