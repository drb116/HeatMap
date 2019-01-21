import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;

public class Stocks {

	public static Map<String,ArrayList<Double>> getData() throws IOException, JSONException, InterruptedException {
		
		String s1 = "https://api.iextrading.com/1.0/stock/market/batch?symbols=MMM,ABT,ABBV,ACN,ATVI,AYI,ADBE,AMD,AAP,AES,AET,AMG,AFL,A,APD,AKAM,ALK,ALB,ARE,ALXN,ALGN,ALLE,AGN,ADS,LNT,ALL,GOOGL,GOOG,MO,AMZN,AEE,AAL,AEP,AXP,AIG,AMT,AWK,AMP,ABC,AME,AMGN,APH,APC,ADI,ANDV,ANSS,ANTM,AON,AOS,APA,AIV,AAPL,AMAT,APTV,ADM,ARNC,AJG,AIZ,T,ADSK,ADP,AZO,AVB,AVY,BHGE,BLL,BAC,BK,BAX,BBT,BDX,BRK.B,BBY,BIIB,BLK,HRB,BA,BWA,BXP,BSX,BHF,BMY,AVGO,BF.B,CHRW,CA,COG,CDNS,CPB,COF,CAH,CBOE,KMX,CCL,CAT,CBG,CBS,CELG,CNC,CNP&types=quote";
        URL url1 = new URL(s1);
        String s2 = "https://api.iextrading.com/1.0/stock/market/batch?symbols=CTL,CERN,CF,SCHW,CHTR,CHK,CVX,CMG,CB,CHD,CI,XEC,CINF,CTAS,CSCO,C,CFG,CTXS,CLX,CME,CMS,KO,CTSH,CL,CMCSA,CMA,CAG,CXO,COP,ED,STZ,COO,GLW,COST,COTY,CCI,CSRA,CSX,CMI,CVS,DHI,DHR,DRI,DVA,DE,DAL,XRAY,DVN,DLR,DFS,DISCA,DISCK,DISH,DG,DLTR,D,DOV,DWDP,DPS,DTE,DRE,DUK,DXC,ETFC,EMN,ETN,EBAY,ECL,EIX,EW,EA,EMR,ETR,EVHC,EOG,EQT,EFX,EQIX,EQR,ESS,EL,ES,RE,EXC,EXPE,EXPD,ESRX,EXR,XOM,FFIV,FB,FAST,FRT,FDX,FIS,FITB,FE,FISV,FLIR,FLS&types=quote";
        URL url2 = new URL(s2);
        String s3 = "https://api.iextrading.com/1.0/stock/market/batch?symbols=FLR,FMC,FL,F,FTV,FBHS,BEN,FCX,GPS,GRMN,IT,GD,GE,GGP,GIS,GM,GPC,GILD,GPN,GS,GT,GWW,HAL,HBI,HOG,HRS,HIG,HAS,HCA,HCP,HP,HSIC,HSY,HES,HPE,HLT,HOLX,HD,HON,HRL,HST,HPQ,HUM,HBAN,HII,IDXX,INFO,ITW,ILMN,IR,INTC,ICE,IBM,INCY,IP,IPG,IFF,INTU,ISRG,IVZ,IQV,IRM,JEC,JBHT,SJM,JNJ,JCI,JPM,JNPR,KSU,K,KEY,KMB,KIM,KMI,KLAC,KSS,KHC,KR,LB,LLL,LH,LRCX,LEG,LEN,LUK,LLY,LNC,LKQ,LMT,L,LOW,LYB,MTB,MAC,M,MRO,MPC,MAR,MMC&types=quote";
        URL url3 = new URL(s3);
        String s4 = "https://api.iextrading.com/1.0/stock/market/batch?symbols=MLM,MAS,MA,MAT,MKC,MCD,MCK,MDT,MRK,MET,MTD,MGM,KORS,MCHP,MU,MSFT,MAA,MHK,TAP,MDLZ,MON,MNST,MCO,MS,MOS,MSI,MYL,NDAQ,NOV,NAVI,NTAP,NFLX,NWL,NFX,NEM,NWSA,NWS,NEE,NLSN,NKE,NI,NBL,JWN,NSC,NTRS,NOC,NCLH,NRG,NUE,NVDA,ORLY,OXY,OMC,OKE,ORCL,PCAR,PKG,PH,PDCO,PAYX,PYPL,PNR,PBCT,PEP,PKI,PRGO,PFE,PCG,PM,PSX,PNW,PXD,PNC,RL,PPG,PPL,PX,PCLN,PFG,PG,PGR,PLD,PRU,PEG,PSA,PHM,PVH,QRVO,PWR,QCOM,DGX,RRC,RJF,RTN,O,RHT,REG,REGN,RF,RSG&types=quote";
        URL url4 = new URL(s4);
        String s5 = "https://api.iextrading.com/1.0/stock/market/batch?symbols=RMD,RHI,ROK,COL,ROP,ROST,RCL,CRM,SBAC,SCG,SLB,SNI,STX,SEE,SRE,SHW,SIG,SPG,SWKS,SLG,SNA,SO,LUV,SPGI,SWK,SBUX,STT,SRCL,SYK,STI,SYMC,SYF,SNPS,SYY,TROW,TPR,TGT,TEL,FTI,TXN,TXT,TMO,TIF,TWX,TJX,TMK,TSS,TSCO,TDG,TRV,TRIP,FOXA,FOX,TSN,UDR,ULTA,USB,UAA,UA,UNP,UAL,UNH,UPS,URI,UTX,UHS,UNM,VFC,VLO,VAR,VTR,VRSN,VRSK,VZ,VRTX,VIAB,V,VNO,VMC,WMT,WBA,DIS,WM,WAT,WEC,WFC,HCN,WDC,WU,WRK,WY,WHR,WMB,WLTW,WYN,WYNN,XEL,XRX,XLNX,XL,XYL,YUM,ZBH,ZION,ZTS&types=quote";
        URL url5 = new URL(s5);
        String s6 = "https://api.iextrading.com/1.0/stock/market/batch?symbols=XYL,YUM,ZBH,ZION,ZTS&types=quote";
        URL url6 = new URL(s6);
        
        Scanner jsonFile1 = new Scanner(url1.openStream());
        
        
        String str = new String();
        while (jsonFile1.hasNext()){
            str += jsonFile1.nextLine();
            str = str.substring(0,str.length()-1);
            str +=",";
        }
        jsonFile1.close();
        String str2 = new String();
        Scanner jsonFile2 = new Scanner(url2.openStream());
        while (jsonFile2.hasNext()){
            str2 += jsonFile2.nextLine();
            str2 = str2.substring(1,str2.length()-1);//delete the line to add in to previous\
            str2 +=",";
        }
        str +=str2;
        str2="";
        jsonFile2.close();
        Scanner jsonFile3 = new Scanner(url3.openStream());
        while (jsonFile3.hasNext()){
            str2 += jsonFile3.nextLine();
            str2 = str2.substring(1,str2.length()-1);//delete the line to add in to previous
            str2 +=",";
        }
        str +=str2;
        str2="";
        jsonFile3.close();
        Scanner jsonFile4 = new Scanner(url4.openStream());
        while (jsonFile4.hasNext()){
            str2 += jsonFile4.nextLine();
            str2 = str2.substring(1,str2.length()-1);//delete the line to add in to previous
            str2 +=",";
        }
        str +=str2;
        str2="";
        jsonFile4.close();
        
        Scanner jsonFile5 = new Scanner(url5.openStream());
        while (jsonFile5.hasNext()){
            str2 += jsonFile5.nextLine();
            str2 = str2.substring(1,str2.length()-1);//delete the line to add in to previous
            str2 +=",";
        }
        str +=str2;
        str2="";
        jsonFile5.close();
        Scanner jsonFile6 = new Scanner(url6.openStream());
        while (jsonFile6.hasNext()){
            str2 += jsonFile6.nextLine();
            str2 = str2.substring(1);
        }
        str +=str2;
       
        jsonFile6.close();

       JSONObject obj = new JSONObject(str);
      
       Map<String,ArrayList<Double>> stockMap = new HashMap<String,ArrayList<Double>>();
       
       Iterator<String> stocks = obj.keys();
       
       

       while (stocks.hasNext()){
    	   String stock = stocks.next();
    	   ArrayList<Double> stockStats = new ArrayList<Double>(2);
    	   stockStats.add(obj.getJSONObject(stock).getJSONObject("quote").getDouble("latestPrice"));
    	   stockStats.add(obj.getJSONObject(stock).getJSONObject("quote").getDouble("changePercent"));
    	   stockMap.put(stock, stockStats);
       }
       
    	    return stockMap;
 
	}

	public static Map<String,String> getDetails(String key) throws JSONException, IOException{
		String s = "https://api.iextrading.com/1.0/stock/"+key+"/quote";
		 URL url = new URL(s);
		Map<String,String> stockDetails = new HashMap<String,String>();
		NumberFormat formatter = new DecimalFormat("0.00");
		Scanner jsonFile = new Scanner(url.openStream());
        
        String str = new String();
        while (jsonFile.hasNext()){
            str += jsonFile.nextLine();
        }
        jsonFile.close();
        JSONObject obj = new JSONObject(str);
        stockDetails.put("name", obj.getString("companyName"));
        stockDetails.put("latestPrice", ""+obj.getDouble("latestPrice"));
        stockDetails.put("high",""+ obj.getDouble("high"));
        stockDetails.put("low",""+ obj.getDouble("low"));
        stockDetails.put("open",""+ obj.getDouble("open"));
        stockDetails.put("change",""+ obj.getDouble("change"));
        stockDetails.put("percent",""+ formatter.format(obj.getDouble("changePercent")*100)+"%");
             
		return stockDetails;
	}
}
