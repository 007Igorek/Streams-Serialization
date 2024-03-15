import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Task2 {
    public static void main(String[] args) {
        GameProgress gp1 = new GameProgress(90, 3, 4, 5.5);
        GameProgress gp2 = new GameProgress(150, 22, 7, 9.9);
        GameProgress gp3 = new GameProgress(40, 3, 10, 105.8);

        String base_path = "E:\\IdeaProjects\\Installing\\Games\\savegames\\";

        saveGame(base_path + "save1.dat", gp1);
        saveGame(base_path + "save2.dat", gp2);
        saveGame(base_path + "save3.dat", gp3);

        String[] save_files = {base_path + "save1.dat", base_path + "save2.dat", base_path + "save3.dat"};
        zipFiles(
            base_path + "zip.zip",
            save_files
        );

        for (String name: save_files) {
            if (name.contains(".dat")) {
                File f = new File(name);
                f.delete();
            }
        }
    }

    public static void saveGame(String path, GameProgress gameProgress) {
        try (
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))
        )
        {
            oos.writeObject(gameProgress);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void zipFiles(String zip_path, String[] files) {
        try (
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zip_path))
        )
        {
            for (String filename: files) {

                ZipEntry entry = new ZipEntry(new File(filename).getName());

                try (FileInputStream fis = new FileInputStream(filename)) {
                    zos.putNextEntry(entry);
                    byte[] data = new byte[fis.available()];
                    fis.read(data);
                    zos.write(data);
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                zos.closeEntry();

            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
