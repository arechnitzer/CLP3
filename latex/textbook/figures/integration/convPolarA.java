                  /*  File:  convPolarA.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class convPolarA extends Template {

     static {templateClass = new convPolarA() ; }

     public void setup() {
          filePrefix = "convPolarA" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.4 ;
          ymin = -0.1 ;
          ymax = 1.4 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double th = 60; double thRad = 60*Math.PI/180 ;
          double Y = 2*Math.sin(thRad) ;
          double rr = 0.1 ;

          fEnv("psFillGray", 0.9) ;

          { 
            double[] xlist = {0, 1, 1, 0} ;
            double[] ylist = {0, 0, 1, 0} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }     

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05 , "tr", "$x$") ;
          fTeXlabel(-0.02, ymax , "tr", "$y$") ; 
          fLine(1,ymin, 1,ymax) ;
          fLine(0,0, 1.3,1.3) ;
 

//          canvas.append( new fPsWrite("[2.5 2.5] 1.0 setdash\n")) ;
//          fLine(0,0, 5,5*Y) ;
//          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

      
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;

          { 
            double[] xlist = {0, 1, 1, 0} ;
            double[] ylist = {0, 0, 1, 0} ;
            fPolygon(xlist, ylist, 4, CLOSED) ;
           }     

          fTeXlabel(1.33, 1.3, "cl", "$y=x$") ;
          fTeXlabel(0.7, 0.3 , "cc", "$\\cD$") ;
          fTeXlabel(1.05, 0.5 , "lc", "$x=1$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;


     }
}
