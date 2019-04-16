package it.unicampania.lsadm.slotmachine

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * LSADM 2019 - Slot Machine
 * Esempio di creazione task asincroni
 */
class MainActivity : AppCompatActivity() {

    var numeroCorrente = 0      // il numero corrente nelle caselle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Imposta la seekbar
        seekLeva.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {

            var start: Long = 0

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Non ci interessa
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                start = System.currentTimeMillis()  // Memorizzo il tempo di inizio
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val durata = System.currentTimeMillis() - start
                val escursione = seekBar?.progress ?: 0
                nuovoLancio(durata, escursione)
            }
        })
    }

    /**
     * Effettua un lancio
     * durata = tempo in ms impiegato per abbassare la leva
     * escursione = escursione raggiunta (0-100)
     */
    fun nuovoLancio(durata: Long, escursione: Int) {
        // Qui devo invocare task asincrono che muoverà le rotelle
        Rotelle().execute(Triple(durata, escursione, numeroCorrente))
    }

}
