package it.unicampania.lsadm.slotmachine

import android.os.AsyncTask

/**
 * Classe per la gestione del task asincrono che muove le rotelle
 * tre tipi:
 *  - parametri iniziali (durata, escursione, valore iniziale),
 *  - aggiornamento rotelle,
 *  - valore finale rotelle
 */
class Rotelle : AsyncTask<Triple<Long, Int, Int>, Int, Int>() {

    // Questo metodo può impiegare più tempo
    override fun doInBackground(vararg params: Triple<Long, Int, Int>?): Int {
        val durata = params[0]?.first ?: 0L
        val escursione = params[0]?.second ?: 0
        val numeroIniziale = params[0]?.third ?:0

        var numero = numeroIniziale

        // Qui occorrerà far ruotare le cifre

        return numero
    }

    // Eventuali operazioni da eseguire prima dell'avvio
    override fun onPreExecute() {
        super.onPreExecute()
    }

    // Aggiornamento durante l'esecuzione
    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        // aggiorno le cifre sullo schermo
    }

    // Termine dell'esecuzione
    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        // aggiorno le cifre
        // determino la vittoria e calcolo i punteggi
    }
}