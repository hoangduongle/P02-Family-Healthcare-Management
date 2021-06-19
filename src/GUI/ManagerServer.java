/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.RegistrationDTO;
import DTO.RegistrationInterface;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ManagerServer extends UnicastRemoteObject implements RegistrationInterface {

    Vector<RegistrationDTO> Rlist;

    public ManagerServer() throws RemoteException {
        Rlist = DAO.FileDAO.readFile();
    }

    @Override
    public boolean createRegistration(RegistrationDTO dto) throws RemoteException {
        if (dto != null) {
            
                Rlist.add(dto);
                DAO.FileDAO.writeFile(Rlist);
                return true;

            
        }
        return false;
    }

    @Override
    public RegistrationDTO findByRegistrationID(String id) throws RemoteException {
        for (RegistrationDTO r : Rlist) {
            if (r.getRegistrationID().equals(id)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public ArrayList<RegistrationDTO> findAllRegistration() throws RemoteException {
        return null;
    }

    @Override
    public boolean removeRegistration(String id) throws RemoteException {
        for (RegistrationDTO r : Rlist) {
            if (r.getRegistrationID().equals(id)) {
                Rlist.remove(r);
                DAO.FileDAO.writeFile(Rlist);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateRegistration(RegistrationDTO dto) throws RemoteException {
        if (dto != null) {
            for (RegistrationDTO r : Rlist) {
                if (r.getRegistrationID().equals(dto.getRegistrationID())) {
                    Rlist.remove(r);
                    Rlist.add(dto);
                    DAO.FileDAO.writeFile(Rlist);
                    return true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            ManagerServer m = new ManagerServer();
            LocateRegistry.createRegistry(9999);
            Runtime r = Runtime.getRuntime();
            r.exec("rmiregistry.exe");
            String ip = "localhost";
            String name = "manager";
            Naming.rebind("rmi://" + ip + ":9999/" + name, m);
            System.out.println("Server Running!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
