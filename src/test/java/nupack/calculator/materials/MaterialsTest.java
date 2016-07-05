package nupack.calculator.materials;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by awood on 2016-07-04.
 */
public class MaterialsTest {

    @Test
    public void getPercentage() throws Exception {
        assertTrue(Materials.ELECTRONICS.getPercentage().equals(.02f));
    }

    @Test
    public void materialForExistingElectronicsEnumElement() {
        Material electronics = Materials.materialFor("ELECTRONICS");
        assertTrue(electronics.getPercentage().equals(.02f));
    }


    @Test
    public void materialForExistingEnumPharmaceuticalsElement() {
        Material electronics = Materials.materialFor("PHARMACEUTICALS");
        assertTrue(electronics.getPercentage().equals(.075f));
    }

    @Test
    public void materialForExistingEnumFoodElement() {
        Material electronics = Materials.materialFor("FOOD");
        assertTrue(electronics.getPercentage().equals(.13f));
    }

    @Test
    public void materialForExistingEnumFoodElementMixedCase() {
        Material electronics = Materials.materialFor("FooD");
        assertTrue(electronics.getPercentage().equals(.13f));
    }

    @Test
    public void materialForNewHelicoptersMaterial(){
        Material material = Materials.materialFor("HELICOPTERS", .55f);
        assertTrue(material.getPercentage().equals(.55f));
        assertTrue(Materials.materialFor("HELICOPTERS").getPercentage().equals(.55f));
    }

    @Test
    public void getName() throws Exception {
        assertTrue(Materials.ELECTRONICS.getName().equals("ELECTRONICS"));
    }

    @Test
    public void getNameIsUpperCaseInMaterialForWithDefaultPercentage(){
        Material material = Materials.materialFor("steel_rebar");
        assertTrue(material.getName().equals("STEEL_REBAR"));
    }

    @Test
    public void getNameIsUpperCaseInMaterialForWithParameterizedPercentage(){
        Material material = Materials.materialFor("iridium_ingots", .88f);
        assertTrue(material.getName().equals("IRIDIUM_INGOTS"));
        assertTrue(Materials.materialFor("iridium_INGOTS").getPercentage().compareTo(.88f) == 0);
    }

    @Test
    public void valueOf(){
        assertTrue(Materials.valueOf("FOOD").getPercentage().compareTo(.13f) == 0);
    }
}