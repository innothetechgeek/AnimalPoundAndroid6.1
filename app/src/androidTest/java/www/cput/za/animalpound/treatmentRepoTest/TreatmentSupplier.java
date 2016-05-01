package www.cput.za.animalpound.treatmentRepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import www.cput.za.animalpound.domain.Treatment;
import www.cput.za.animalpound.repository.treatment.Impl.TreatmentSupplierRepoImpl;
import www.cput.za.animalpound.repository.treatment.TreatmentSuplierRepository;

/**
 * Created by Game330 on 2016-04-29.
 */
public class TreatmentSupplier extends AndroidTestCase {
    private static final String TAG="TREATMENT_TYPE TEST";
    private Long id;


    /*public void testCreateReadUpdateDelete() throws Exception {
        TreatmentSuplierRepository repo = new TreatmentSupplierRepoImpl(this.getContext());
        // CREATE

        TreatmentSupplier createEntity = new TreatmentSupplier
                .treatmentNO(Long.parseLong("234324"))
                .Instructions("One every evening")
                .ExpiryDate("23/04/2017")
                .build();
        Treatment insertedEntity = repo.save(createEntity);
        id=insertedEntity.getTreatmentNO();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Treatment> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        Treatment entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);


        //UPDATE ENTITY
        Treatment updateEntity = new Treatment.Builder()
                .copy(entity)
                .treatmentNO(Long.parseLong("234324"))
                .build();
        repo.update(updateEntity);
        Treatment newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","234324",newEntity.getTreatmentNO());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Treatment deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    } */
}
