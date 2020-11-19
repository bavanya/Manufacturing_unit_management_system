package net.javaguides.springboot.service;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.dao.*;
import java.util.List;
import java.util.Set;
import net.javaguides.springboot.model.Client;

public interface IspringService {

    List<Firm> findAllFirms();

    List<Item> findAllItems();

    List<Material> findAllMaterials();

    List<Employee> findAllEmployees();

    List<Supplier> findAllSuppliers();

    List<Client> findAllClients();

    List<Clientorder> findAllClientorders();

    List<Transaction> findAllTransactions();

    List<Miscellaneoustransfer> findAllMiscellaneoustransfers();

    List<Purchaseorder> findAllPurchaseorders();

    void addGreeting(GreetingDto greeting);

    void addItem(ItemDto item);

    void editItem(ItemDto item, Long id);

    void editMaterial(MaterialDto material, Long id);

    void editEmployee(EmployeeDao employee,Long id);

    void addMaterial(MaterialDto material);

    void addEmployee(EmployeeDao employee);

    void addClient(ClientDto client);

    void addSupplier(ClientDto supplier);

    void deleteItemById(Long id);

    void deleteMaterialById(Long id);

    Material getMaterialById(Long id);

    Item getItemById(Long id);

    Employee getEmployeeById(Long id);

    Purchaseorder getPurchaseById(Long id);

    Clientorder getProjectById(Long id);

    Client getClientById(Long id);

    Supplier getSupplierById(Long id);

    Bank getBankByClientId(Long id);

    Bank getBankBySupplierId(Long id);

    Bank getBankById(Long id);

    void addMaterialToItem(Long item_id, MaterialDto material);

    void deleteMaterialFromItem(Long item_id, MaterialDto material);

    List<Employee> searchEmployee(String keyword);

    List<Client> searchClient(String keyword);

    List<Supplier> searchSupplier(String keyword);

    List<Firm> searchFirm(String keyword);

    List<Item> searchItem(String keyword);

    List<Material> searchMaterial(String keyword);

    void addOrder(Long id, ClientOrderDto clientOrder);

    void addPurchase(Long id, ClientOrderDto clientOrder);

    List<Employee> findOfficers();

    List<Clientorder> getProjectsByClientId(Long id);

    Set<Purchaseorder> getPurchasesBySupplierId(Long id);

    List<Employee> getEngineers();

    void addPieceByItemId(Long id, PieceDto piece);

    List<Piece> getPiecesByItemId(Long id);

    Piece getPieceById(Long id);

    void editPiece(PieceDto new_piece, Long id);
}