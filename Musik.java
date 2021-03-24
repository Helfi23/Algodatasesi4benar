/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.playlist.musik;
import java.io.Serializable;
/**
 *
 * @author Helfi Apriliyandi F
 */

public class Musik implements Serializable
{
    private String artis;
    private String judul;
    private String durasi;
    private String genre;
    private int peringkat;

    //Creates a playlist object with an artis, judul, durasi, genre, and peringkat.
    public Musik(String artis, String judul, String durasi, String genre, int peringkat)
    {
        this.artis = artis;
        this.judul = judul;
        this.durasi = durasi;
        this.genre = genre;
        this.peringkat = peringkat;
    }

    //Sets Song's artis to argument artis.
    public void setArtis(String artis)
    {
        this.artis = artis;
    }

    //Return the value of artis in a Song.
    public String getArtis()
    {
        return artis;
    }

    //Sets Song's judul to argument judul.
    public void setJudul(String judul)
    {
        this.judul = judul;
    }

    //Returns the value of judul in a Song.
    public String getJudul()
    {
        return this.judul;
    }

    //Sets song's durasi to durasi argument; creates InvalidLengthException.
    /* This is not exactly how I wanted to do this, instead
     * this checks for validity by seeing if the argument String
     * contains both a colon and only numbers.*/
    public void setDurasi(String durasi) throws InvalidLengthException
    {
        if(durasi.matches("(\\d.*):(\\d.*)"))
        {
            this.durasi = durasi;
        }
        else
        {
            throw new InvalidLengthException(durasi);
        }
    }

    //Returns the value of durasi in a Song.
    public String getDurasi()
    {
        return this.durasi;

    }

    //Sets Song's genre to argument genre.
    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    //Returns value of genre in a Song.
    public String getGenre()
    {
        return this.genre;
    }

    //Sets Song's peringkat to argument peringkat; creates InvalidRatingException.
    public void setPeringkat(int peringkat) throws InvalidRatingException
    {
        if(peringkat > 0 || peringkat < 6)
        {
            this.peringkat = peringkat;		}
        else
        {
            throw new InvalidRatingException(peringkat);
        }

    }

    //Returns peringkat value in a Song.
    public int getPeringkat()
    {
        return this.peringkat;
    }


} //End class

