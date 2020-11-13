package net.javaguides.springboot.service;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.model.Client;
import net.javaguides.springboot.dao.*;
import net.javaguides.springboot.repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class springService implements IspringService {

    @Autowired
    private firmRepository frepository;

    @Autowired
    private itemRepository irepository;

    @Autowired
    private materialRepository mrepository;

    @Autowired
    private employeeRepository erepository;

    @Autowired
    private supplierRepository srepository;

    @Autowired
    private clientRepository crepository;

    @Autowired
    private miscellaneoustransferRepository mirepository;

    @Autowired
    private transactionRepository trepository;

    @Autowired
    private clientorderRepository corepository;

    @Autowired
    private purchaseorderRepository prepository;

    @Autowired
    private greetingRepository grepository;

    @Autowired
    private bankRepository brepository;

    @Autowired
    private itemmaterialRepository imrepository;

    @Autowired
    private employeeQueryRepository eqrepository;

    @Autowired
    private clientQueryRepository cqrepository;

    @Autowired
    private supplierQueryRepository sqrepository;

    @Autowired
    private firmQueryRepository fqrepository;

    @Autowired
    private itemQueryRepository iqrepository;

    @Autowired
    private materialQueryRepository mqrepository;

    @Autowired
    private bankQueryRepository bqrepository;

    @Autowired
    private pieceRepository pcrepository;

    @Autowired
    private pieceQueryRepository pqrepository;

    @Autowired
    private clientorderQueryRepository coqrepository;

    @Autowired
    private itemmaterialQueryRepository imqrepository;

    @Override
    public List<Firm> findAllFirms() {
        List<Firm> qcities = fqrepository.getFirms();

        return qcities;
    }

    @Override
    public List<Item> findAllItems() {
        List<Item> qcities = iqrepository.getItems();
        return qcities;
    }

    @Override
    public List<Material> findAllMaterials() {
        List<Material> qcities = mqrepository.getMaterials();
        return qcities;
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> cities =  eqrepository.getEmployees();
        return cities;
    }

    @Override
    public List<Supplier> findAllSuppliers() {

        List<Supplier> cities =  sqrepository.getSuppliers();

        return cities;
    }

    @Override
    public List<Client> findAllClients() {

        List<Client> cities = cqrepository.getClients();

        return cities;
    }

    @Override
    public List<Miscellaneoustransfer> findAllMiscellaneoustransfers() {

        List<Miscellaneoustransfer> cities = (List<Miscellaneoustransfer>) mirepository.findAll();

        return cities;
    }

    @Override
    public List<Transaction> findAllTransactions() {

        List<Transaction> cities = (List<Transaction>) trepository.findAll();

        return cities;
    }

    @Override
    public List<Clientorder> findAllClientorders() {

        List<Clientorder> cities = (List<Clientorder>) corepository.findAll();
        return cities;
    }

    @Override
    public List<Purchaseorder> findAllPurchaseorders() {

        List<Purchaseorder> cities = (List<Purchaseorder>) prepository.findAll();

        return cities;
    }

    @Override
    public void addGreeting(GreetingDto greeting){
        grepository.save(new Greeting(greeting.getContent()));
        return;
    };

    @Override
    public void addItem(ItemDto item){
        
        if(iqrepository.itemByName(item.getName()).isEmpty() && iqrepository.itemByDescription(item.getDescription()).isEmpty()){
            irepository.save(new Item(item.getName(), item.getDescription(), 0, new HashSet<>()));
            return;
        }

        return;
    };

    @Override
    public void editItem(ItemDto item, Long id){
        if(iqrepository.itemByName(item.getName()).isEmpty() && iqrepository.itemByDescription(item.getDescription()).isEmpty()){
            Item m = irepository.findById(id).get();
            m.setName(item.name);
            m.setDescription(item.description);
            m = irepository.save(m);
            return;
        }
        Item m = irepository.findById(id).get();
            m.setName(item.name);
            m.setDescription(item.description);
            m = irepository.save(m);
        return;
    }

    @Override
    public void editPiece(PieceDto new_piece, Long id){
        Piece m = pcrepository.findById(id).get();
        if(m.getStatus().equals("SOLD")){
            return;
        }
        Item item = m.getItem();
        int quantity = item.getQuantity();
        if(m.getStatus().equals("ACCEPTED")){
            if(new_piece.getStatus().equals("REJECTED")){
                m.setStatus(new_piece.getStatus());
                quantity-=1;
            }
            else if(new_piece.getStatus().equals("SOLD")){
                m.setStatus(new_piece.getStatus());
                quantity-=1;
            }
        }
        else if(m.getStatus().equals("REJECTED")){
            if(new_piece.getStatus().equals("ACCEPTED")){
                m.setStatus(new_piece.getStatus());
                quantity+=1;
            }
            else if(new_piece.getStatus().equals("SOLD")){
                m.setStatus(new_piece.getStatus());
            }
        }
        else if(m.getStatus().equals("INPROGRESS")){
            if(new_piece.getStatus().equals("ACCEPTED")){
                m.setStatus(new_piece.getStatus());
                quantity+=1;
            }
            else if(new_piece.getStatus().equals("SOLD") || new_piece.getStatus().equals("REJECTED")){
                m.setStatus(new_piece.getStatus());
            }
        }
        m.setEnddate(new_piece.getEnddate());
        m = pcrepository.save(m);
        item.setQuantity(quantity);
        irepository.save(item);
        return;
    }

    @Override
    public void editMaterial(MaterialDto material, Long id){
        
        if(mqrepository.materialByName(material.getName()).isEmpty() && mqrepository.materialByDescription(material.getDescription()).isEmpty()){
            Material m = mrepository.findById(id).get();
            m.setName(material.name);
            m.setDescription(material.description);
            m = mrepository.save(m);
            return;
        }
        Material m = mrepository.findById(id).get();
            m.setName(material.name);
            m.setDescription(material.description);
            m = mrepository.save(m);
        return;
    }

    @Override
    public void editEmployee(EmployeeDao employee,Long id){
        /*if(!(eqrepository.employeeByName(employee.getName()).isEmpty())){
            return;
        }*/
        Employee e = erepository.findById(id).get();
        e.setName(employee.name);
        e.setMonthly_salary(employee.monthly_salary);
        e.setDesignation(employee.designation);
        e.setStatus(employee.status);
        e = erepository.save(e);
        return;
    }

    @Override
    public void addMaterial(MaterialDto material){
        
        if(mqrepository.materialByName(material.getName()).isEmpty() && mqrepository.materialByDescription(material.getDescription()).isEmpty()){
            mrepository.save(new Material(material.getName(), material.getDescription(), 0));
        }
        return;
    };

    @Override
    public void addEmployee(EmployeeDao employee){
        /*
        if(!(eqrepository.employeeByName(employee.getName()).isEmpty() &&  bqrepository.bankByIfscCode(employee.getIfsccode()).isEmpty() && bqrepository.bankByBankName(employee.getBank()).isEmpty() && bqrepository.bankByBranch(employee.getBranch()).isEmpty() && bqrepository.bankByMicrNumber(employee.getMicrnumber()).isEmpty() && bqrepository.bankByAccountNumber(employee.getAccountnumber()).isEmpty())){
            return;
        }*/
        Bank bank = new Bank(employee.getIfsccode(), employee.getBank() , employee.getBranch(), employee.getMicrnumber(), employee.getAccountnumber());
        brepository.save(bank);
        erepository.save(new Employee(employee.getName(), employee.getMonthly_salary(), employee.getDesignation(), employee.getStatus(), bank));
        return;
    }

    @Override
    public void addClient(ClientDto employee){
        /*
        if(!(cqrepository.clientByContactNumber(employee.getContactnumber()).isEmpty() && fqrepository.firmByAddress(employee.getAddress()).isEmpty() && fqrepository.firmByName(employee.getName()).isEmpty() && fqrepository.firmByGSTNumber(employee.getGstnumber()).isEmpty() && fqrepository.firmByRegistrationNumber(employee.getRegistrationnumber()).isEmpty())){
            return;
        }

        if(!(bqrepository.bankByIfscCode(employee.getIfsccode()).isEmpty() && bqrepository.bankByBankName(employee.getBank()).isEmpty() && bqrepository.bankByBranch(employee.getBranch()).isEmpty() && bqrepository.bankByMicrNumber(employee.getMicrnumber()).isEmpty() && bqrepository.bankByAccountNumber(employee.getAccountnumber()).isEmpty())){
            return;
        }
        */
        Bank bank = new Bank(employee.getIfsccode(), employee.getBank(), employee.getBranch(), employee.getMicrnumber(), employee.getAccountnumber());
        brepository.save(bank);
 
        Firm firm = new Firm(employee.getAddress(), employee.getName(), employee.getRegistrationnumber(), employee.getGstnumber(), bank);
        frepository.save(firm);
        crepository.save(new Client(employee.getContactnumber(), firm));
        return;
    }

    @Override
    public void addSupplier(ClientDto employee){
        /*
        if(!(sqrepository.supplierByContactNumber(employee.getContactnumber()).isEmpty() && fqrepository.firmByAddress(employee.getAddress()).isEmpty() && fqrepository.firmByName(employee.getName()).isEmpty() && fqrepository.firmByGSTNumber(employee.getGstnumber()).isEmpty() && fqrepository.firmByRegistrationNumber(employee.getRegistrationnumber()).isEmpty())){
            return;
        }

        if(!(bqrepository.bankByIfscCode(employee.getIfsccode()).isEmpty() && bqrepository.bankByBankName(employee.getBank()).isEmpty() && bqrepository.bankByBranch(employee.getBranch()).isEmpty() && bqrepository.bankByMicrNumber(employee.getMicrnumber()).isEmpty() && bqrepository.bankByAccountNumber(employee.getAccountnumber()).isEmpty())){
            return;
        }
        */
        Bank bank = new Bank(employee.getIfsccode(), employee.getBank(), employee.getBranch(), employee.getMicrnumber(), employee.getAccountnumber());
        brepository.save(bank);
 
        Firm firm = new Firm(employee.getAddress(), employee.getName(), employee.getRegistrationnumber(), employee.getGstnumber(), bank);
        frepository.save(firm);

        srepository.save(new Supplier(employee.getContactnumber(), firm));
        return;

    }

    @Override
    public void deleteItemById(Long id){
        irepository.deleteById(id);
        return;
    };

    @Override
    public void deleteMaterialById(Long id){
        mrepository.deleteById(id);
        return;
    };

    @Override
    public Material getMaterialById(Long id){
         return mqrepository.materialById(id);
    }

    @Override
    public Item getItemById(Long id){
         return iqrepository.itemById(id);
    }

    @Override
    public Employee getEmployeeById(Long id){
        return eqrepository.employeeById(id);
    }

    @Override
    public Purchaseorder getPurchaseById(Long id){
        return prepository.findById(id).get();
    }

    @Override
    public Clientorder getProjectById(Long id){
        return corepository.findById(id).get();
    }

    @Override
    public Client getClientById(Long id){
        return cqrepository.clientById(id);
    }

    @Override
    public Supplier getSupplierById(Long id){
        return sqrepository.supplierById(id);
    }

    @Override
    public Bank getBankByClientId(Long id){
        return cqrepository.bankByClientId(id);
    }


    @Override
    public Bank getBankBySupplierId(Long id){
        return sqrepository.bankBySupplierId(id);
    }

    @Override
    public Bank getBankById(Long id){
        return bqrepository.bankById(id);
    }

    @Override
    public List<Employee> searchEmployee(String keyword){
        if(keyword != null){
            return eqrepository.searchEmployee(keyword);
        }

        return (List<Employee>) erepository.findAll();
    }

    @Override
    public List<Client> searchClient(String keyword){
        if(keyword != null){
            return cqrepository.searchClient(keyword);
        }

        return (List<Client>) crepository.findAll();
    }

    @Override
    public List<Supplier> searchSupplier(String keyword){
        if(keyword != null){
            return sqrepository.searchSupplier(keyword);
        }

        return (List<Supplier>) srepository.findAll();
    }

    @Override
    public List<Firm> searchFirm(String keyword){
        if(keyword != null){
            return fqrepository.searchFirm(keyword);
        }

        return (List<Firm>) frepository.findAll();
    }

    @Override
    public List<Item> searchItem(String keyword){
    if(keyword != null){
        return iqrepository.searchItem(keyword);
    }

    return (List<Item>) irepository.findAll();
    }

    @Override
    public List<Material> searchMaterial(String keyword){
    if(keyword != null){
        return mqrepository.searchMaterial(keyword);
    }

    return (List<Material>) mrepository.findAll();
    }

    @Override
    public void addOrder(Long id, ClientOrderDto clientOrder){

        Item material = iqrepository.itemByName(clientOrder.getMaterial_name()).get(0);
        int quantity = material.getQuantity();
        int cquantity = clientOrder.getQuantity_in_units();
        Set<Piece> pieces = material.getPieces();
        if(quantity>=cquantity){

        Client client = cqrepository.clientById(id);
        
        Transaction transaction = new Transaction(clientOrder.getTransaction_date(), 0, clientOrder.getCredit(), client.getFirm().getBank());
        trepository.save(transaction);

        quantity -= clientOrder.getQuantity_in_units();
        material.setQuantity(quantity);
        int counter = clientOrder.getQuantity_in_units();
        Iterator value = pieces.iterator(); 
        while (value.hasNext() && (counter!=0) ) { 
            Piece piece = (Piece) value.next();
            if(piece.getStatus().equals("ACCEPTED")){
                piece.setStatus("SOLD");
                counter-=1;
            }
            pcrepository.save(piece);
        }   
        material = irepository.save(material);
        

        Clientorder purchase_order = new Clientorder(client, eqrepository.employeeByName(clientOrder.getEmployee_name()), transaction, iqrepository.itemByName(clientOrder.getMaterial_name()).get(0), clientOrder.getQuantity_in_units(), clientOrder.getRupees_per_unit());
        corepository.save(purchase_order);
        return;
        }

        else {
            return;
        }
        
    }

    @Override
    public void addPurchase(Long id, ClientOrderDto clientOrder){
        
        Supplier supplier = sqrepository.supplierById(id);

        Transaction transaction = new Transaction(clientOrder.getTransaction_date(), clientOrder.getDebit(), 0, supplier.getFirm().getBank());
        trepository.save(transaction);

        Material material = mqrepository.materialByName(clientOrder.getMaterial_name()).get(0);
        int quantity = material.getQuantity();
        quantity+=clientOrder.getQuantity_in_units();
        material.setQuantity(quantity);
        material = mrepository.save(material);
        

        Purchaseorder purchase_order = new Purchaseorder(supplier, eqrepository.employeeByName(clientOrder.getEmployee_name()), transaction, mqrepository.materialByName(clientOrder.getMaterial_name()).get(0), clientOrder.getQuantity_in_units(), clientOrder.getRupees_per_unit());
        prepository.save(purchase_order);
        return;
    }

    @Override
    public Set<Purchaseorder> getPurchasesBySupplierId(Long id){
        return sqrepository.supplierById(id).getPurchaseorders();

    }


    @Override
    public void addPieceByItemId(Long id, PieceDto piece){
        Item item = iqrepository.itemById(id);
        Set<ItemMaterial> itemmaterials = item.getItemmaterials();
        Iterator value = itemmaterials.iterator(); 
        while (value.hasNext()) { 
            ItemMaterial im = (ItemMaterial) value.next();
            Material material = im.getMaterial();
            int usedQuantity =  im.getQuantity();
            int presentQuantity = material.getQuantity();
            if(presentQuantity<usedQuantity){
                return;
            }
            presentQuantity-=usedQuantity;
            material.setQuantity(presentQuantity);
            mrepository.save(material);
        } 
        pcrepository.save(new Piece(piece.getStartdate(), piece.getEnddate(), iqrepository.itemById(id), eqrepository.employeeByName(piece.getEngineername()), "INPROGRESS"));
        return;
    }

    @Override
    public Piece getPieceById(Long id){
        return pcrepository.findById(id).get();
    }

    @Override
    public List<Piece> getPiecesByItemId(Long id){
        return pqrepository.getPiecesByItemId(id);
    }

    @Override
    public List<Employee> findOfficers(){
        return eqrepository.getByDesignation("OFFICER");
    }

    @Override
    public List<Employee> getEngineers(){
        return eqrepository.getByDesignation("ENGINEER");
    }


    @Override
    public List<Clientorder> getProjectsByClientId(Long id){
        return coqrepository.getProjectsByClientId(id);
    }


    @Override
    public void addMaterialToItem(Long item_id, MaterialDto material){

        
        Item item = irepository.findById(item_id).get();
        Set<ItemMaterial> materials_set = item.getItemmaterials();

        if(!materials_set.isEmpty()){
            if(imqrepository.getItemMaterialByMaterial(item_id, material.getName()).getMaterial().getName().equals(material.getName()) && imqrepository.getItemMaterialByMaterial(item_id, material.getName()).getItem().getId().equals(item_id)){
                return;
            }
        }

        materials_set.add(new ItemMaterial(material.getQuantity(), mqrepository.materialByName(material.getName()).get(0), irepository.findById(item_id).get()));
        item.setItemmaterials(materials_set);
        item = irepository.save(item);
        
        return;
    }

    @Override
    public void deleteMaterialFromItem(Long item_id, MaterialDto material){
        ItemMaterial im = imqrepository.getByItemIdAndMaterialName(item_id, material.getName());
        imrepository.deleteById(im.getId());
        return;
    }

}

