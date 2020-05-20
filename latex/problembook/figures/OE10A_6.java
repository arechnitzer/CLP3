                  /*  File:  OE10A_6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10A_6 extends Template {

     static {templateClass = new OE10A_6() ; }

     public void setup() {
          filePrefix = "OE10A_6" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*1.5 ;      // in inches
          ysize = 1.4*1.5 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.3 ;
          ymin = -0.1 ;
          ymax = 1.3 ;
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
         { 
            double[] xlist = { 0, 0,  1, 0} ;
            double[] ylist = { 0, 1,  1, 0} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          fEnv("psFillGray", 1.0) ;
          fCurve("[t*t, t]",1, 0,1, FILLED) ;
         { 
            double[] xlist = { 0, 0.25,  1, 0} ;
            double[] ylist = { 0, 0.5,  1, 0} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.02, ymax, "tr", "$y$") ;

          fLine(xmin,1, xmax,1) ;
          fTeXlabel(0.5,1.05, "cb", "$y=1$") ;
          fCurve("[t*t, t]",1, 0,xmax, OPEN) ;
          fTeXlabel(0.55,Math.sqrt(0.5)-0.1, "ct", "$y=\\sqrt{x}$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("[t*t, t]",1, 0,1, OPEN) ;
          fLine(0,0, 0,1) ;
          fLine(0,1, 1,1) ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(1, 1, r, r, FILLED) ;
          fTeXlabel(1.0, 0.95, "tl", "$\\scriptstyle (1,1)$") ;

//          canvas.append( new fPsWrite("0.6 setgray\n")) ;
//          double X = 0.3 ;
//          double YB = Math.sqrt(X) ;
//          double YT = 1 ;
//          fEnv("lineWidth", 8.0) ;
//          fLine(X,YB, X,YT) ;
//          canvas.append( new fPsWrite("0.3 setgray\n")) ;
//          YB = 0.7 ;
//          YT = 0.8 ;
//          fLine(X,YB, X,YT) ;          
        
     }
}
