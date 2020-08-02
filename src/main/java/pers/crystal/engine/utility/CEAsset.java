package pers.crystal.engine.utility;

import java.io.File;
import java.util.*;

public class CEAsset {
    private static HashMap<String,File> asset = new HashMap<String,File>();
    static{
        LinkedList<File> list = new LinkedList<File>();

		list.add(new File(".\\asset"));

		while (!list.isEmpty()) {
			File[] files = list.pop().listFiles();
			for (File file : files) {
				if (file.isDirectory())
					list.add(file);
				if (file.isFile())
                    asset.put(file.getName(),file);
			}
		}
    }



    public static File GetFile(String name){
        return asset.get(name);
    }
}