package factory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Factory {
	private static Factory factory;
	
	private static final String DIRECTORY = "src/factory/product";
	
	private static HashMap<String, String> productTypes;
	
	public Factory() {
		productTypes = new HashMap <String, String>();
		loadProducts();
		// System.out.println(productTypes.toString());
	}
	
	/**
	 * Singleton instance of Factory.
	 * 
	 * @return singleton instance
	 */
	public static Factory getInstance() {
		if (factory == null)
			factory = new Factory();
		return factory;
	}
	
	public static Product createProduct(String productType) {
		if (productTypes.containsKey(productType)) {
			try {
	            		return (Product) Class.forName(
	        			productTypes.get(productType)
	            		).newInstance();
			} catch (Throwable e) {
				System.err.println("Product " + productType + " could not be created.");
	        	}
		}
		System.err.println("Product " + productType + " does not exist.");
		return null;
	}

	private static void loadProducts() {
		String abs = new File(DIRECTORY).getAbsolutePath();
		
		Queue<File> queue = new LinkedList<File>();
		queue.add(new File(abs));

		while (!queue.isEmpty()) {
			File node = queue.remove();
			File[] childs = node.listFiles(
				new FilenameFilter() {
					@Override
					public boolean accept(File pathName, String name) {
						if (name.endsWith(".java"))
							loadProduct(pathName, name);
						return pathName.isDirectory();
					}
				}
			);

			if (childs != null) {
				for (File child : childs) {
					queue.add(child);
				}
			}
		}
	}
	
	private static void loadProduct(File pathName, String name) {
		String formattedDir = DIRECTORY.substring(4).replace("/", ".");
		
		String dirValue = pathName + "." + name;
		dirValue = dirValue.replace("\\", ".");
		
		dirValue = dirValue.substring(
			dirValue.indexOf(formattedDir), 
			dirValue.indexOf(".java")
		);
		
		String key = name.substring(0, name.indexOf(".java"));
		String value = dirValue;
		productTypes.put(key, value);
	}
}
