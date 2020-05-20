                  /*  File:  OE06A_6h.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06A_6h extends Template {

     static {templateClass = new OE06A_6h() ; }

     public void setup() {
          filePrefix = "OE06A_6h" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*1.0 ;      // in inches
          ysize = 2.4*1.0 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.3 ;
          ymin = -0.1 ;
          ymax = 2.3 ;
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
            double[] xlist = { 0, 1,  0,} ;
            double[] ylist = { 0, 1,  2} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fLine(xmin,xmin, xmax,xmax) ;
          fLine(2,0, 2-ymax,ymax) ;
          fTeXlabel(0.6,1.5, "cl", "$x=2-y$") ;
          fTeXlabel(0.6,0.5, "cl", "$x=y$") ;

          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine(xmin, 1, 1,1) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
          fTeXlabel(xmin-0.03,0.98, "cr", "$y=1$") ;



          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
         { 
            double[] xlist = { 0, 1,  0,} ;
            double[] ylist = { 0, 1,  2} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }             


          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(1, 1, r, r, FILLED) ;
          fTeXlabel(1.05, 1.0, "cl", "$\\scriptstyle (1,1)$") ;
          fDisk(0, 2, r, r, FILLED) ;
          fTeXlabel(-0.05, 1.95, "cr", "$\\scriptstyle (0,2)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double Y = 0.5 ;
          double XL = 0 ;
          double XR = Y ;
          fEnv("lineWidth", 8.0) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XL = 0.2 ;
          XR = 0.3 ;
          fLine(XL,Y, XR,Y) ;  

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          Y = 1.5 ;
          XL = 0 ;
          XR = 2-Y ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XL = 0.2 ;
          XR = 0.3 ;
          fLine(XL,Y, XR,Y) ;          
        
     }
}
