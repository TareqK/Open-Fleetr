/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Endpoints;

import Entities.HistoricalLocationEntity;
import Entities.HistoricalStatusEntity;
import Entities.UserEntity;
import com.tna.common.AccessError;
import com.tna.common.UserAccessControl;
import com.tna.data.Persistence;
import com.tna.endpoints.AuthorisedEndpoint;
import com.tna.endpoints.BasicEndpoint;
import javax.servlet.annotation.WebServlet;
import org.json.simple.JSONObject;

/**
 *
 * @author tareq
 */
@WebServlet("/statushistory/*")
public class HistoricalStatusEndpoint  extends AuthorisedEndpoint {

   @Override
    public JSONObject doList(String token) throws AccessError {
       UserAccessControl.authOperation(UserEntity.class, token, 2);
       return Persistence.list(HistoricalStatusEntity.class);
    }

    @Override
    public JSONObject doCreate(JSONObject json, String token) throws AccessError {
        throw new AccessError(AccessError.ERROR_TYPE.OPERATION_FAILED);
    }

    @Override
    public JSONObject doUpdate(JSONObject json, int resource, String token) throws AccessError {
        throw new AccessError(AccessError.ERROR_TYPE.OPERATION_FAILED);
    }

    @Override
    public JSONObject doRead(int resource, String token) throws AccessError {
        UserAccessControl.authOperation(UserEntity.class, token, 2);
        JSONObject obj = new JSONObject();
        obj.put("vehicleId",resource);
        return Persistence.listByProperties(HistoricalStatusEntity.class, obj);
        
      }

    @Override
    public JSONObject doDelete(int resource, String token) throws AccessError {
        throw new AccessError(AccessError.ERROR_TYPE.OPERATION_FAILED);
    }
    
    
}
