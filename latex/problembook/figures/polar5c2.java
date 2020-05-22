                  /*  File:  polar5c2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar5c2 extends Template {

     static {templateClass = new polar5c2() ; }

     public void setup() {
          filePrefix = "polar5c2" ;    
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
          double th = 60 ; double thRad = th*Math.PI/180 ;
          double dth = 7 ;  double dthRad = dth*Math.PI/180 ;
          double rrr = 2/Math.sin(thRad+dthRad) ;  
              double xxx = rrr*Math.cos(thRad+dthRad) ;  
          double rr = 2/Math.sin(thRad) ;  
              double xx = rr*Math.cos(thRad) ;  
          fEnv("psFillGray", 0.6) ;
          { 
            double[] xlist = { 0, xx, xxx} ;
            double[] ylist = { 0, 2, 2} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           } 
          fEnv("psFillGray", 0.3) ;
          double r1 = 0.75*rr ;
          double r2 = 0.65*rr ;
          fEllipticalArc(0,0, r1, r1, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r2, r2, th,th+dth, WEDGE+FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fLine(0,0, xmax, xmax) ;
          fLine(0,2, xmax, 2) ;


          fTeXlabel(xmax+0.05, xmax+0.05, "cl", "$\\theta=\\frac{\\pi}{4}$") ;
          fTeXlabel(xmax+0.05, 2, "cl", "$r\\sin\\theta=2$") ;


             
          fEnv("lineWidth",1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          { 
            double[] xlist = { 0, 2, 0} ;
            double[] ylist = { 0, 2, 2} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }   

          
     }
}
