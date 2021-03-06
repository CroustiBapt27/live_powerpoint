package fr.cpe.Model.Model;

import fr.cpe.Role;
import fr.cpe.Model.EJB.UserDaoInterface;
import fr.cpe.UserModel;
import javax.ejb.EJB;
import javax.ejb.Singleton;


@Singleton
public class DataContainer {


    @EJB
    UserDaoInterface myDB;

    UserModel tempUser;

    Role tempRole;


    public Role checkUser(UserModel user) {
        //Check in DB

        tempUser = myDB.getUserByLogin(user);

        if(tempUser == null){
            System.out.println("Wrong Login or Password ");

            return Role.NONE;
        }
        System.out.println("tempUser login : "+tempUser.getLogin());
        System.out.println("tempUser pwd : "+tempUser.getPwd());
        System.out.println("tempUser firstname : "+tempUser.getSurname());
        System.out.println("tempUser lastname : "+tempUser.getLastname());

        switch (tempUser.getRole()) {
            case "admin":
                tempRole = Role.admin;
                break;
            case "user":
                tempRole = Role.user;

                break;
            default:
                tempRole = Role.user;
                break;
        }
        return tempRole;

    }
}
