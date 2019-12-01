package mx.edu.ittepic.tpdm_u4_5_prac1

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.edu.ittepic.tpdm_u45_practica1.OyenteAcelerometro
import mx.edu.ittepic.tpdm_u4_5_prac1.Lienzo

class MainActivity : AppCompatActivity() {
    var x = 0f
    var contShake = 0
    var distancia = 0f
    var sensorManager : SensorManager?= null
    var oyenteProximidad : OyenteProximidad ?= null
    var oyenteShake : OyenteShake ?= null
    var oyenteAcelerometro : OyenteAcelerometro ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        oyenteProximidad = mx.edu.ittepic.tpdm_u4_5_prac1.OyenteProximidad(this)
        oyenteAcelerometro = OyenteAcelerometro(this)
        oyenteShake = OyenteShake(this)

        sensorManager?.registerListener(oyenteProximidad,sensorManager?.getDefaultSensor(Sensor.TYPE_PROXIMITY),
            SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager?.registerListener(oyenteAcelerometro,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager?.registerListener(oyenteShake,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_GAME)


    }
}
