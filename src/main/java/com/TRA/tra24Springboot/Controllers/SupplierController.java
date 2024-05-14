package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Supplier;
import com.TRA.tra24Springboot.Services.SupplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
   @Autowired
    SupplierServices supplierServices;


    @PostMapping("add")
    public Supplier addSupplier( Supplier supplier){

        return supplierServices.addSupplier(supplier);
    }
    @PutMapping("update")
    public String updateSupplier(@RequestParam Integer id, @RequestParam String quantity) {
        return supplierServices.updateMinimumOrderQuantity(id,quantity);
    }
    @PostMapping("delete")
    public String deleteSupplier(@PathVariable Integer id){
        return supplierServices.remove(id);
    }




    //UPDATE SUPPLIER
   /** @PutMapping("update")
    public Supplier updateSupplier(@RequestBody Supplier supplierUpdating) {


        ContactDetails pd = supplierUpdating.getContactDetails();
        pd.setUpdatedDate(new Date());

        supplierUpdating.setContactDetails(pd);
        supplierUpdating.setUpdatedDate(new Date());

        globalSupplier= supplierUpdating;
        return supplierRepository.save(supplierUpdating);
    }
    // delete
    @PostMapping("delete/{id}")
    public String deleteSupplier(@PathVariable Integer id){

        if(globalSupplier.getId().equals(id)){
            globalSupplier.setIsActive(Boolean.FALSE);
            System.out.println(globalSupplier.toString());

        }
        return "Success!";
    }**/


}
