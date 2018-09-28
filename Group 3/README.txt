2) Find out the different Spring annotations. Create a simple html page, a controller and a repository (no db needed at this point, just mock answers) to simulate a basic MVC app, which should handle at least an HTTP request.


index.html (/) is the view with a simple menu from where you can call the 2 HTTP get request (/items and /item/id)

ItemController.java is the controller who receive those HTTP requests and obtain items from a service Interface called ItemRepository. Then returns the list of items to the view (or just one item).


ItemRepository has one implementation called ItemRepositoryImpl. I used dependency injection (by setter) to allow ItemController to obtain items from an ItemRepository Interface, so different implemantations of the repository could be used (for example recovering items from a real DB instead of mock items) and the controller will not be affected and will communicate by the same methods through the interface.

Used annotations:

@Controller --> Added in ItemController. Bring this class into the context, and inject an instance of the service into the class.  

@Service --> Added in ItemRepositoryImpl. Tells Spring this class is a Spring Bean to be managed by the Spring Framework. Alternatively, you could explicitly define the bean in a Spring configuration file

@Autowired --> Used on the setter (setItemRepository()) of the ItemController.This directs Spring to inject a Spring managed bean into this class

@RequestMapping --> Ensures that HTTP requests to /items and /item/{id} are mapped to the respective methods in the ItemController.

@ComponentScan --> By using this annotation Spring will scan the specified package for Spring components. 

