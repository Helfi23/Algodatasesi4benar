/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.playlist.musik;
import java.io.*;
import java.util.Scanner;
/**
 *
 *@author Helfi Apriliyandi F
 */
public class Menu
{

    private Scanner scan = new Scanner(System.in);
    private playlist playlist = new playlist();

    //Display a menu, prompts for user input (int selection), and returns the input.
    public int lihatMenu()
    {
        int selection;

        System.out.print("\nPilih Menu?"
                + "\n1- Tampilkan Data Playlist"+ "\n2- Tambah Data Playlist"
                + "\n3- Hapus Data Playlist" + "\n4- Tambah Data Playlist dalam urutan tertentu" + "\n5- Hapus Data Playlist dalam urutan tertentu"
                + " \n6- Hapus Semua Playlist" + " \n7- Exit" + "\nSelection: ");
        selection = scan.nextInt();
        System.out.print("\n");

        return selection;
    }

    //Displays menu from lihatMenu(): Contains a switch,
    //executes case based on returned int from lihatMenu().
    public void runMenu()
    {

        int selection = lihatMenu();

        switch (selection) {
            case 1:
                viewPlaylist();
                runMenu();
                break;
            case 2:
                Tambahmusik();
                savePlaylist();
                runMenu();
                break;
            case 3:
                Hampusmusik();
                savePlaylist();
                runMenu();
                break;
            case 4:
                updateSong();
                savePlaylist();
                runMenu();
                break;
            case 5:
                Hampusmusik();
                savePlaylist();
                runMenu();
                break;
            case 6:
                playlist.deletePlaylist();
                runMenu();
                break;
            case 7:
                savePlaylist();
                System.exit(0);
                break;
            default:
                System.out.println("\n Pilihan tidak Valid!\n");
                runMenu();
        }

    }

    //Creates a new Song with user to input for artist, title,
    //length, genre, rating; adds Song to a Playlist.
    /* I had a lot of trouble getting the scanner get the input and assign it correctly.
     * Someone suggested I utilize scanner.reset(), but I'd get a scanner exception. This way worked.*/
    public void Tambahmusik()
    {
        Musik newMusik = new Musik(null, null, null, null, 0);

        newMusik.setArtis(scan.nextLine());
        System.out.print("Masukan Nama Artis: ");
        newMusik.setArtis(scan.nextLine());
        System.out.print("Masukan Judul: ");
        newMusik.setJudul(scan.nextLine());
        do
        {
            try
            {
                System.out.print("Durasi Lagu: ");
                newMusik.setDurasi(scan.next());
            }
            catch (InvalidLengthException invalidLength)
            {
                System.out.print(invalidLength.toString());
                System.out.print("Durasi Lagu: \"minutes:seconds\".\n");
            }
        }while (newMusik.getDurasi() == null);

        newMusik.setGenre(scan.nextLine());
        System.out.print("Masukan Genre: ");
        newMusik.setGenre(scan.nextLine());
        boolean flag = false;
        do
        {
            try
            {
                System.out.print("Masukan Urutan: ");
                newMusik.setPeringkat(scan.nextInt());
                flag = true;
            }
            catch (InvalidRatingException invalidRating)
            {
                System.out.print(invalidRating.toString());
            }
        } while(flag == false);

        playlist.Tambahmusik(newMusik);
    }

    //Formats and displays all Songs in Playlist.
    public void viewPlaylist()
    {
        if(playlist.getPlaylistSize() == 0)
        {
            System.out.println("\nData Musik Kosong !");
        }
        else
        {
            for(int i = 0; i < playlist.getPlaylistSize(); i++)
            {
                System.out.print("\n#" + (i+1) + " ");
                System.out.print(""+ playlist.getArtis(i) + " - ");
                System.out.print("\"" +playlist.getArtis(i)+ "\"" + ", ");
                System.out.print(playlist.getDurasi(i) + ", ");
                System.out.print(playlist.getGenre(i) + ", ");
                System.out.print(playlist.getPeringkat(i)+ " out of 5");
            }
            System.out.print("\n");
        }
    }

    
    public void updateSong()
    {
        if(playlist.getPlaylistSize() == 0)
        {
            System.out.println("\nData Musik Kosong");
        }
        else
        {
            viewPlaylist();
            System.out.print("\nSilahkan pilih musik untuk diupdate: ");
            int musikpilihan = scan.nextInt();

            System.out.print("\napa yang anda ingin ubah?\n"+"1- Artist\n"+"2- Title\n"
                    +"3- Length\n"+"4- Genre\n"+"5- Rating\n"+"Selection: ");

            int updateSelection = scan.nextInt();

            switch (updateSelection) {
                case 1:
                    System.out.print("Masukan Artis: ");
                    String artist = scan.next();
                    playlist.updateArtis(musikpilihan, artist);
                    break;
                case 2:
                    System.out.print("Masukan Judul: ");
                    String title = scan.next();
                    playlist.updateJudul(musikpilihan, title);
                    break;
                case 3:
                    boolean lengthFlag = false;
                    do
                    {
                        try
                        {
                            System.out.print("Durasi Lagu: ");
                            String length = scan.next();
                            playlist.updateDurasi(musikpilihan, length);
                            lengthFlag = true;
                        }
                        catch (InvalidLengthException invalidLength)
                        {
                            System.out.print(invalidLength.toString());
                            System.out.print("Durasinya adalah : \"minutes:seconds\".\n");
                        }
                    }while (lengthFlag == false);
                    break;
                case 4:
                    System.out.print("Masukan Genre: ");
                    String genre = scan.next();
                    playlist.updateGenre(musikpilihan, genre);
                    break;
                case 5:
                    boolean ratingFlag = false;
                    do
                    {
                        try
                        {
                            System.out.print("Masukan Perinkat: ");
                            int rating = scan.nextInt();
                            playlist.updatePeringkat(musikpilihan, rating);
                            ratingFlag = true;
                        }
                        catch (InvalidRatingException invalidLength)
                        {
                            System.out.print(invalidLength.toString());
                        }
                    }while (ratingFlag == false);
                    break;
                default:
                    System.out.println("\nPilihan Tidak Ada\n");
                    runMenu();
            }
        }
    }

    public void Hampusmusik()
    {
        if(playlist.getPlaylistSize() == 0)
        {
            System.out.println("\nTidak Ada Musik!");
        }
        else
        {
            viewPlaylist();
            boolean flag = false;
            do
            {
                System.out.print("\nSiliha yang mau dihapus: ");
                int removeSelection = scan.nextInt();

                if(removeSelection < playlist.getPlaylistSize() || removeSelection > playlist.getPlaylistSize())
                {
                    System.out.print("Tidak ada pilihan!\n");
                }
                else
                {
                    playlist.removeSong(--removeSelection);
                    flag = true;
                }
            } while(flag == false);
        }
    }

    public void savePlaylist()
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("playlist");

            ObjectOutputStream outObjectStream = new ObjectOutputStream(fileOutputStream);

            outObjectStream.writeObject(playlist);

            outObjectStream.flush();
            outObjectStream.close();
        }
        catch(FileNotFoundException fnfException)
        {
            System.out.println("Tidak Ada FIle");
        }
        catch(IOException ioException)
        {
            System.out.println("bad IO");
        }

    }

    public void loadPlaylist()
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream("playlist");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            playlist = (playlist)objectInputStream.readObject();

            objectInputStream.close();
        }
        catch(FileNotFoundException fnfException)
        {
            System.out.println("Tidak Ada Pilihan!");
        }
        catch(IOException ioException)
        {
            System.out.println("IO tidak baik");
        }

        catch(ClassNotFoundException cnfException)
        {
            System.out.println("This is not a Playlist.");
        }

    }


}

