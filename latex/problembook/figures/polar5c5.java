                  /*  File:  polar5c5.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar5c5 extends Template {

     static {templateClass = new polar5c5() ; }

     public void setup() {
          filePrefix = "polar5c5" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.5 ;      // in inches
          ysize = 2.6*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  2.4 ;
          ymin = -0.2 ;
          ymax =  2.4 ;
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
          fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = { 0, 2, 0} ;
            double[] ylist = { 0, 2, 2} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }      

          fEnv("lineWidth", 0.5) ;

          double r = 2; 
          double r1 = 0.75*r ;
          double r2 = 1.2*r ;
          double dr = 0.1*r ;
          double th = 48 ; double thRad = th*Math.PI/180 ;
          double dth = 5 ;  double dthRad = dth*Math.PI/180 ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r2, r2, 45,85, WEDGE+FILLED) ;  
          fEnv("psFillGray", 0.3) ;
          fEllipticalArc(0,0, r2, r2, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,0, r2-dr, r2-dr, 45,85, WEDGE+FILLED) ;
          fEllipticalArc(0,0, 2, 2, 45,90, WEDGE+FILLED) ;
          fEnv("psFillGray", 1.0) ;
          { 
            double[] xlist = { 0.1, 2, 2, 0.1} ;
            double[] ylist = { 2,   2, 3, 3} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }  
//          fEnv("psFillGray", 0.6) ;
//          fEllipticalArc(0,0, r1, r1, 45,90, WEDGE+FILLED) ;  
//          fEnv("psFillGray", 0.3) ;
//          th = 60 ; dth = 8 ;
//          fEllipticalArc(0,0, r1, r1, th,th+dth, WEDGE+FILLED) ;
//          fEnv("psFillGray", 0.9) ;
//          fEllipticalArc(0,0, r1-dr, r1-dr, 45,90, WEDGE+FILLED) ;

          fEllipticalArc(0,0, 2, 2, 30,120, OPEN) ;
//          fEllipticalArc(0,0, r1, r1, 45,90, OPEN) ;
//          fEllipticalArc(0,0, r1-dr, r1-dr, 45,90, OPEN) ;
          fEllipticalArc(0,0, r2, r2, 45,90, OPEN) ;
          fEllipticalArc(0,0, r2-dr, r2-dr, 45,90, OPEN) ;




          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fLine(0,0, xmax, xmax) ;
          fLine(0,2, xmax, 2) ;


          fTeXlabel(xmax+0.05, xmax+0.05, "cl", "$\\theta=\\frac{\\pi}{4}$") ;
          fTeXlabel(xmax+0.05, 2, "cl", "$r\\sin\\theta=2$") ;
          fTeXlabel(2*Math.cos(30*Math.PI/180)+0.05, 
                    2*Math.sin(30*Math.PI/180), "cl","$r=2$");

             
          fEnv("lineWidth",1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          { 
            double[] xlist = { 0, 2, 0} ;
            double[] ylist = { 0, 2, 2} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }  

          double rr = 0.07 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(2,2, rr,rr, FILLED) ;
          fTeXlabel(2,2.05, "br", "$(2,2)$") ;

          
     }
}
