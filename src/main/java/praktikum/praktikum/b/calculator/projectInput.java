/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum.praktikum.b.calculator;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ERIK
 */
@Controller
public class projectInput {
    @RequestMapping("/input")
    public String getData(HttpServletRequest data, Model diskonsayur){
        
        String namasayur = data.getParameter("var_name");
        String inputharga = data.getParameter("var_price");
        String jumlah = data.getParameter("var_quantity");
        String pembayaran = data.getParameter("var_payment");
        String diskon = "";
        
        Double cHarga = Double.valueOf(inputharga);
        Double cTotal = Double.valueOf(jumlah);
        Double cPayment = Double.valueOf(pembayaran);
        Double totalPay = cHarga * cTotal;
        Double getTotal = null;
        
         if (totalPay < 16000)
        {
            getTotal = totalPay - (0 * totalPay/100);
            diskon = "0%";
        }
        else if (totalPay >= 16000 && totalPay < 25000)
        {
            getTotal = totalPay - (10 * totalPay/100);
            diskon = "10%";
        }
        else
        {
            getTotal = totalPay - (15 * totalPay/100);
            diskon = "15%";
        }
         
        Double kembalian = cPayment - getTotal;
         
        diskonsayur.addAttribute("name", namasayur);
        diskonsayur.addAttribute("price", inputharga);
        diskonsayur.addAttribute("quantity", jumlah);
        diskonsayur.addAttribute("total", getTotal);
        diskonsayur.addAttribute("payment", pembayaran);
        diskonsayur.addAttribute("diskon", diskon);
        diskonsayur.addAttribute("kembalian", kembalian);
        return "responseView";
    }
}
