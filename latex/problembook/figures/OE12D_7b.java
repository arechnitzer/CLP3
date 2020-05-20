                  /*  File:  OE12D_7b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE12D_7b extends Template {

     static {templateClass = new OE12D_7b() ; }

     public void setup() {
          filePrefix = "OE12D_7b" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.3*0.3 ;      // in inches
          ysize = 5.3*0.3 ;   // in inches. 
          xmin = -0.5 ;
          xmax = 3.8 ;
          ymin = -0.5 ;
          ymax = 4.8 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          fCurve("[sqrt(8-t), t]",1, 0,4, FILLED) ;
          double sq8 = Math.sqrt(8) ;
          double sq7 = Math.sqrt(7) ;
          { 
            double[] xlist = { 0, 1, 2, sq7, sq8} ;
            double[] ylist = { 0, 1, 4, 1, 0} ;
            fPolygon(xlist, ylist, 5, FILLED) ;
           }             
          fEnv("psFillGray", 1.0) ;
          fCurve("[t, t*t]",1, 0,2, FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fCurve("[t, t*t]",1, xmin,xmax, OPEN) ;
          fTeXlabel(Math.sqrt(2.5)-0.15, 2.5, "cr", "$\\scriptstyle y=x^2$") ;
          fCurve("[t, 8-t*t]",1, xmin,xmax, OPEN) ;
          fTeXlabel(Math.sqrt(8-2.5)+0.15, 2.5, "cl", "$\\scriptstyle y=8-x^2$") ;
          fLine(xmin, 4, xmax, 4) ;
          fTeXlabel(xmax+0.2, 4, "cl", "$y=4$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fLine(0, 0, sq8, 0) ;
          fCurve("[sqrt(8-t), t]",1, 0,4, OPEN) ;
          fCurve("[t, t*t]",1, 0,2, OPEN) ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.1 ;
          fDisk(0, 0, r, r, FILLED) ;
          fDisk(2, 4, r, r, FILLED) ;
          fTeXlabel(2.15, 4.05, "bl", "$\\scriptstyle (2,4)$") ;
          fDisk(sq8, 0, r, r, FILLED) ;
          fTeXlabel(sq8+0.1, 0.05, "bl", "$\\scriptstyle (\\sqrt{8},0)$") ;

          fEnv("lineWidth",0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
               fLine(2,ymax, 2,ymin) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;




          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = 1.3 ;
          double YT = X*X ;
          double YB = 0 ;
          fEnv("lineWidth", 4.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YT = 1.0 ;
          YB = 0.8 ;
          fLine(X,YB, X,YT) ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          X = 2.35 ;
          YT = 8-X*X ;
          YB = 0 ;
          fEnv("lineWidth", 4.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YT = 1.8 ;
          YB = 1.6 ;
          fLine(X,YB, X,YT) ;





          
     }
}
