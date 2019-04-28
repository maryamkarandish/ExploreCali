package com.example.ec.explorecali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class ExplorecaliApplication implements CommandLineRunner {
public class ExplorecaliApplication  {

//	@Autowired
//	private TourPackageService tourPackageService;
//	@Autowired
//	private TourService tourService;

	public static void main(String[] args) {
		SpringApplication.run(ExplorecaliApplication.class, args);
		System.out.println("Hello!");
	}


//	@Override
//	public void run(String... strings) throws Exception {
		//Create the default tour packages
//		tourPackageService.createTourPackage("BC", "Backpack Cal");
//		tourPackageService.createTourPackage("CC", "California Calm");
//		tourPackageService.createTourPackage("CH", "California Hot springs");
//		tourPackageService.createTourPackage("CY", "Cycle California");
//		tourPackageService.createTourPackage("DS", "From Desert to Sea");
//		tourPackageService.createTourPackage("KC", "Kids California");
//		tourPackageService.createTourPackage("NW", "Nature Watch");
//		tourPackageService.createTourPackage("SC", "Snowboard Cali");
//		tourPackageService.createTourPackage("TC", "Taste of California");
//		System.out.println("Number of tours packages =" + tourPackageService.total());
//		importTours().forEach(t->tourService.createTour(t.title,t.description,t.blurb,Double.parseDouble(t.price),t.length,t.bullets,
//				t.keywords,t.packageType, Difficulty.valueOf(t.difficulty),
//				Region.findByLabel(t.region)));
//		System.out.println(tourService.total());
//	}

//	static class TourFromFile{
//		private String packageType, title, description, blurb, price, length, bullets, keywords, difficulty, region;
//		static List<TourFromFile> importTours() throws IOException{
//			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
//					readValue(TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"),new TypeReference<List<TourFromFile>>(){});
//		}
//	}
}
