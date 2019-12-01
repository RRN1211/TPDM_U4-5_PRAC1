package mx.edu.ittepic.tpdm_u4_5_prac1

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class OyenteShake (p : MainActivity) : SensorEventListener{
    var puntero = p
    var ultAct : Long = 0
    var x = 0f
    var y = 0f
    var z = 0f
    var ult_x = 0f
    var ult_y = 0f
    var ult_z = 0f
    var con = 0
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(p0: SensorEvent?) {
        var curTime : Long = System.currentTimeMillis()
        if ((curTime - ultAct) > 100){
            var difftime = (curTime - ultAct)
            ultAct = curTime

            x= p0!!.values[0]
            y= p0!!.values[1]
            z= p0!!.values[2]
            var speed : Float = Math.abs(x+y+z - ult_x - ult_y - ult_z) / difftime * 10000
            if (speed > 800){
                puntero.contShake++
                if (puntero.contShake == 4){
                    puntero.contShake = 0
                }
                ult_x = x
                ult_y = y
                ult_z = z
            }
        }
    }

}