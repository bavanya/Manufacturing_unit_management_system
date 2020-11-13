package net.javaguides.springboot.web;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import net.javaguides.springboot.service.IspringService;
import org.springframework.web.bind.annotation.ModelAttribute;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.dao.*;
import java.util.*;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class MainController {

	@Autowired
    private IspringService cityService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}

	@GetMapping("/showFirms")
    public String findFirms(Model model, @RequestParam String keyword) {

        List<Firm> listFirms= cityService.searchFirm(keyword);
        model.addAttribute("firms", listFirms);
        model.addAttribute("keyword", keyword);
        return "showFirms";
	}
	
	@GetMapping("/showItems")
    public String findItems(Model model, @RequestParam String keyword) {
        List<Item> listItems = cityService.searchItem(keyword);
        model.addAttribute("items", listItems);
        model.addAttribute("keyword", keyword);
        return "showItems";
    }
    
	@GetMapping("/showMaterials")
    public String findMaterials(Model model, @RequestParam String keyword) {
        List<Material> listMaterials = cityService.searchMaterial(keyword);
        model.addAttribute("materials", listMaterials);
        model.addAttribute("keyword", keyword);
        return "showMaterials";
	}
	
	@GetMapping("/showEmployees")
    public String findEmployees(Model model, @RequestParam String keyword) {

        List<Employee> listEmployees = cityService.searchEmployee(keyword);
        model.addAttribute("employees", listEmployees);
        model.addAttribute("keyword", keyword);
        return "showEmployees";
	}
	
	@GetMapping("/showSuppliers")
    public String findSuppliers(Model model, @RequestParam String keyword) {
        List<Supplier> listSuppliers = cityService.searchSupplier(keyword);
        model.addAttribute("suppliers", listSuppliers);
        model.addAttribute("keyword", keyword);
        return "showSuppliers";
	}
	
	@GetMapping("/showClients")
    public String findClients(Model model, @RequestParam String keyword) {

        List<Client> listClients = cityService.searchClient(keyword);
        model.addAttribute("clients", listClients);
        model.addAttribute("keyword", keyword);
        return "showClients";
    }

    @GetMapping("/showTransactions")
    public String findTransactions(Model model) {

        //var firms = cityService.findAllFirms();

        model.addAttribute("transactions", cityService.findAllTransactions());

        return "showTransactions";
    }

    @GetMapping("/showClientorders")
    public String findClientorders(Model model) {

        //var firms = cityService.findAllFirms();

        model.addAttribute("clientorders", cityService.findAllClientorders());

        return "showClientorders";
    }

    @GetMapping("/showMiscellaneoustransfers")
    public String findMiscellaneoustransfers(Model model) {

        //var firms = cityService.findAllFirms();

        model.addAttribute("miscellaneoustransfers", cityService.findAllMiscellaneoustransfers());

        return "showMiscellaneoustransfers";
    }

    @GetMapping("/showPurchaseorders")
    public String findPurchaseorders(Model model) {

        //var firms = cityService.findAllFirms();

        model.addAttribute("purchaseorders", cityService.findAllPurchaseorders());

        return "showPurchaseorders";
    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
      model.addAttribute("greeting", new Greeting());
      return "greeting";
    }
  
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute GreetingDto greeting, Model model) {
      cityService.addGreeting(greeting);
      model.addAttribute("greeting", greeting);
      return "result";
    }

    @GetMapping("/addItemRegistration")
    public String getItemRegistrationPage(Model model) {
        model.addAttribute("item", new ItemDto());
        return "addItemRegistration";
    }

    @GetMapping("/editItem/addItemRegistration")
    public String getItemRegistrationPageAfterEditItem(Model model) {
        model.addAttribute("item", new ItemDto());
        return "addItemRegistration";
    }

    @GetMapping("/editMaterial/addMaterialRegistration")
    public String getMaterialRegistrationPageAfterEditMaterial(Model model) {
        model.addAttribute("material", new MaterialDto());
        return "addMaterialRegistration";
    }

    @GetMapping("/editEmployee/addEmployeeRegistration")
    public String getEmployeeRegistrationPageAfterEditEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDao());
        return "addEmployeeRegistration";
    }

    @PostMapping("/addItem")
    public String addItem(@Valid ItemDto item, BindingResult bindingResult, Model model) {

        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.addItem(item);
        return "redirect:/showItems?keyword=";
    }
    

    @PostMapping("/editItem/{id}")
    public String editItem(@Valid ItemDto new_item, BindingResult bindingResult, @PathVariable Long id, Model model) {
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.editItem(new_item, id);
        return "redirect:/showItems?keyword=";
    }

    @PostMapping("/editPiece/{id}")
    public String editPiece(@Valid PieceDto new_piece, BindingResult bindingResult,  @PathVariable Long id, Model model) {
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.editPiece(new_piece, id);
        return "redirect:/showItems?keyword=";
    }

    @PostMapping("/editMaterial/{id}")
    public String editMaterial(@Valid MaterialDto new_material, BindingResult bindingResult, @PathVariable Long id, Model model) {
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.editMaterial(new_material, id);
        return "redirect:/showMaterials?keyword=";
    }
    

    @PostMapping("/editEmployee/{id}")
    public String editEmployee(@Valid EmployeeDao new_material, BindingResult bindingResult, @PathVariable Long id, Model model) {
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.editEmployee(new_material, id);
        return "redirect:/showEmployees?keyword=";
    }
    
    @GetMapping("/addMaterialRegistration")
    public String getMaterialRegistrationPage(Model model) {
        model.addAttribute("material", new MaterialDto());
        return "addMaterialRegistration";
    }

    @PostMapping("/addMaterial")
    public String addMaterial(@Valid MaterialDto material, BindingResult bindingResult, Model model) {
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.addMaterial(material);
        return "redirect:/showMaterials?keyword=";
    }
    
    @GetMapping("/addEmployeeRegistration")
    public String getEmployeeRegistrationPage(Model model) {
        model.addAttribute("employee", new EmployeeDao());
        return "addEmployeeRegistration";
    }

    @GetMapping("/addClientRegistration")
    public String getClientRegistrationPage(Model model) {
        model.addAttribute("client", new ClientDto());
        return "addClientRegistration";
    }

    @GetMapping("/addSupplierRegistration")
    public String getSupplierRegistrationPage(Model model) {
        model.addAttribute("client", new ClientDto());
        return "addSupplierRegistration";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@Valid EmployeeDao employee, BindingResult bindingResult, Model model) {
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.addEmployee(employee);
        return "redirect:/showEmployees?keyword=";
    }

    @PostMapping("/addClient")
    public String addClient(@Valid ClientDto client, BindingResult bindingResult, Model model) {
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.addClient(client);
        return "redirect:/showClients?keyword=";
    }

    @PostMapping("/addSupplier")
    public String addSupplier(@Valid ClientDto supplier,  BindingResult bindingResult, Model model) {
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.addSupplier(supplier);
        model.addAttribute("suppliers", cityService.findAllSuppliers());
        return "showSuppliers";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable Long id, Model model) {
        cityService.deleteItemById(id);
        return "redirect:/showItems?keyword=";
    }

    @GetMapping("/updateItem/{id}")
    public String updateItem(@PathVariable Long id, Model model) {
        model.addAttribute("item", cityService.getItemById(id));
        return "updateItem";
    }

    @GetMapping("/updatePiece/{id}")
    public String updatePiece(@PathVariable Long id, Model model) {
        model.addAttribute("piece", cityService.getPieceById(id));
        return "updatePiece";
    }

    @GetMapping("/updateMaterial/{id}")
    public String updateMaterial(@PathVariable Long id, Model model) {
        model.addAttribute("material", cityService.getMaterialById(id));
        return "updateMaterial";
    }

    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", cityService.getEmployeeById(id));
        return "updateEmployee";
    }
    
    @GetMapping("/deleteMaterial/{id}")
    public String deleteMaterial(@PathVariable Long id, Model model) {
        cityService.deleteMaterialById(id);
        return "redirect:/showMaterials?keyword=";
        
    }
    
    @GetMapping("/getMaterial/{id}")
    public String getMaterial(@PathVariable Long id, Model model) {
        model.addAttribute("material", cityService.getMaterialById(id));
        return "showMaterialById";
    }
    
    @GetMapping("/getItem/{id}")
    public String getItem(@PathVariable Long id, Model model) {
        model.addAttribute("item", cityService.getItemById(id));
        model.addAttribute("materials", cityService.findAllMaterials());
        model.addAttribute("material", new MaterialDto());
        model.addAttribute("piece", new PieceDto());
        model.addAttribute("engineers", cityService.getEngineers());
        return "showItemById";
    }

    @GetMapping("/addClientOrder/{id}")
    public String addClientOrder(@PathVariable Long id, Model model){
        model.addAttribute("clientOrder", new ClientOrderDto());
        model.addAttribute("officers", cityService.findOfficers());
        model.addAttribute("client", cityService.getClientById(id));
        model.addAttribute("items", cityService.findAllItems());
        return "addClientOrder";
    }

    @GetMapping("/addSupplierOrder/{id}")
    public String addSupplierOrder(@PathVariable Long id, Model model){
        model.addAttribute("clientOrder", new ClientOrderDto());
        model.addAttribute("officers", cityService.findOfficers());
        model.addAttribute("materials", cityService.findAllMaterials());
        model.addAttribute("supplier", cityService.getSupplierById(id));
        return "addSupplierOrder";
    }

    @PostMapping("/addOrder/{id}")
    public String addOrder(@ModelAttribute ClientOrderDto clientOrder, @PathVariable Long id, Model model){
        
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.addOrder(id, clientOrder);
        return "redirect:/showClients?keyword=";
    }

    @PostMapping("/addPurchase/{id}")
    public String addPurchase(@ModelAttribute ClientOrderDto clientOrder, @PathVariable Long id, Model model){
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.addPurchase(id, clientOrder);
        return "redirect:/showSuppliers?keyword=";
    }

    @PostMapping("/addMaterialToItem/{item_id}")
    public String addMaterialToItem(@ModelAttribute MaterialDto material, @PathVariable Long item_id, Model model) {
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.addMaterialToItem(item_id, material);
        return "redirect:/showItems?keyword=";
    }

    @GetMapping("/getEmployee/{id}")
    public String getEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", cityService.getEmployeeById(id));
        return "showEmployeeById";
    }

    
    @GetMapping("/getPurchase/{id}")
    public String getPurchase(@PathVariable Long id, Model model) {
        model.addAttribute("purchase", cityService.getPurchaseById(id));
        return "showPurchaseById";
    }

    @GetMapping("/getProject/{id}")
    public String getProject(@PathVariable Long id, Model model) {
        model.addAttribute("purchase", cityService.getProjectById(id));
        return "showProjectById";
    }
    

    @GetMapping("/getClient/{id}")
    public String getClient(@PathVariable Long id, Model model) {
        model.addAttribute("client", cityService.getClientById(id));
        model.addAttribute("bank", cityService.getBankByClientId(id));
        model.addAttribute("projects", cityService.getProjectsByClientId(id));
        return "showClientById";
    }

    @GetMapping("/getSupplier/{id}")
    public String getSupplier(@PathVariable Long id, Model model) {
        model.addAttribute("supplier", cityService.getSupplierById(id));
        model.addAttribute("bank", cityService.getBankBySupplierId(id));
        model.addAttribute("purchases", cityService.getPurchasesBySupplierId(id));
        return "showSupplierById";
    }

    @PostMapping("/deleteMaterialFromItem/{item_id}")
    public String deleteMaterialFromItem(@Valid MaterialDto material, BindingResult bindingResult, @PathVariable Long item_id, Model model){
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.deleteMaterialFromItem(item_id, material);
        return "redirect:/showItems?keyword=";
    }

    @PostMapping("/addPiece/{item_id}")
    public String addPiece(@Valid PieceDto piece, BindingResult bindingResult, @PathVariable Long item_id, Model model){
        /*if (bindingResult.hasErrors()) {
            return "index";
         }*/
        cityService.addPieceByItemId(item_id, piece);
        return "redirect:/showItems?keyword=";
    }

    @GetMapping("/getPieces/{id}")
    public String getPieceByItemId(@PathVariable Long id, Model model) {
        model.addAttribute("pieces", cityService.getPiecesByItemId(id));
        return "showPiecesById";
    }

}
