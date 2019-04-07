/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
class KursCollection {

    constructor(url) {
        this.url = url || "http://localhost:8080/SkatUla/KurseWS/";
        this.username = "";
        this.password = "";
    }
    
    setAuthData(username, passwort){
        this.username = username;
        this.password = password;
    }
    
    async getKurse(){
        
        let response = await fetch(this.url, {
            method: "GET",
            headers: {
                "accept": "application/json",
                "username": this.username,
                "password": this.password
            }
        });
        return await response.json();
    }
}

