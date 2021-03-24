/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.playlist.musik;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Helfi Apriliyandi F
 */
public class playlist implements Serializable
{
    private ArrayList<Musik> playlist;

  
    public playlist()
    {
        playlist = new ArrayList<Musik>();
    }

   
    public void Tambahmusik(Musik song)
    {
        playlist.add(song);
    }

    
    public int getPlaylistSize()
    {
        return playlist.size();
    }

    
    public String getArtis(int index)
    {
        return playlist.get(index).getArtis();
    }

   
    public String getJudul(int index)
    {
        return playlist.get(index).getJudul();
    }

    
    public String getDurasi(int index)
    {
        return playlist.get(index).getDurasi();
    }

    
    public String getGenre(int index)
    {
        return playlist.get(index).getGenre();
    }

    
    public int getPeringkat(int index)
    {
        return playlist.get(index).getPeringkat();
    }

   
    public void updateArtis(int index, String artist)
    {
        playlist.get(--index).setArtis(artist);
    }

    
    public void updateJudul(int index, String title)
    {
        playlist.get(--index).setJudul(title);
    }

    
    public void updateDurasi(int index, String length) throws InvalidLengthException
    {
        if(length.matches("(\\d.*):(\\d.*)"))
        {
            playlist.get(--index).setDurasi(length);
        }
        else
        {
            throw new InvalidLengthException(length);
        }
    }

    
    public void updateGenre(int index, String genre)
    {
        playlist.get(--index).setGenre(genre);
    }

    
    public void updatePeringkat(int index, int rating) throws InvalidRatingException
    {
        if(rating > 0 && rating < 6)
        {
            playlist.get(--index).setPeringkat(rating);
        }
        else
        {
            throw new InvalidRatingException(rating);
        }
    }

    
    public void removeSong(int index)
    {
        playlist.remove(index);
    }

    
    public void deletePlaylist()
    {
        if(playlist.size() == 0)
        {
            System.out.print("Tidak ada data\n");
        }
        else
        {
            playlist.clear();
            System.out.print("Delete Sukses.\n");
        }
    }

} 

