import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        StringBuilder logs = new StringBuilder();

        File games_dir = new File("E:\\IdeaProjects\\Installing\\Games");

        String[] dirs = {"src", "res", "savegames", "temp"};

        for (String dir_name: dirs) {
            File new_dir = new File(games_dir, dir_name);
            if (new_dir.mkdir()) {
                logs.append(String.format("Directory %s created\n", new_dir.getAbsolutePath()));
            }
            else {
                logs.append(String.format("Directory %s not created\n", new_dir.getAbsolutePath()));
            }
        }


        // In src
        File main_dir = new File(games_dir + "\\src\\main");
        if (main_dir.mkdir()) {
            logs.append(String.format("Directory %s created\n", main_dir.getAbsolutePath()));

            String[] file_names = {"Main.java", "Utils.java"};

            for (String file_name: file_names) {
                File new_file = new File(main_dir, file_name);
                try {
                    if (new_file.createNewFile()) {
                        logs.append(String.format("File %s created\n", new_file.getAbsolutePath()));
                    }
                    else {
                        logs.append(String.format("File %s not created\n", new_file.getAbsolutePath()));
                    }
                }
                catch (IOException e) {
                    logs.append(String.format("File %s not created\n", new_file.getAbsolutePath()));
                }

            }
        }
        else {
            logs.append(String.format("Directory %s not created\n", main_dir.getAbsolutePath()));
        }

        File test_dir = new File(games_dir + "\\src\\test");
        if (test_dir.mkdir()) {
            logs.append(String.format("Directory %s created\n", test_dir.getAbsolutePath()));
        }
        else {
            logs.append(String.format("Directory %s not created\n", test_dir.getAbsolutePath()));
        }

        // In res
        File res_dir = new File(games_dir, "res");

        String[] res_dir_names = {"drawables", "vectors", "icons"};
        for (String dir_name: res_dir_names) {
            File new_dir = new File(res_dir, dir_name);
            if (new_dir.mkdir()) {
                logs.append(String.format("Directory %s created\n", new_dir.getAbsolutePath()));
            }
            else {
                logs.append(String.format("Directory %s not created\n", new_dir.getAbsolutePath()));
            }
        }

        // In temp
        File temp_file = new File(games_dir + "\\temp\\temp.txt");
        try {
            if (temp_file.createNewFile()) {
                logs.append(String.format("File %s created\n", temp_file.getAbsolutePath()));

                // Write logs
                try (FileWriter writer = new FileWriter(temp_file)) {
                    writer.write(logs.toString());
                }
                catch (IOException e) {
                    System.out.println("Can't write logs in " + temp_file);
                }
            }
            else {
                logs.append(String.format("File %s not created\n", temp_file.getAbsolutePath()));
            }
        }
        catch (IOException e) {
            logs.append(String.format("File %s not created\n", temp_file.getAbsolutePath()));
        }

    }
}
