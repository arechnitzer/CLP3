                  /*  File:  OE08D_7w.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE08D_7w extends Template {

     static {templateClass = new OE08D_7w() ; }

     public void setup() {
          filePrefix = "OE08D_7w" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.4 ;      // in inches
          ysize = 4.5*0.4 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 2.4;
          ymin = -2.1 ;
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
          double pi = Math.PI ;
          fEnv("psFillGray", 0.9) ;
          double th = 60 ;   double thRad = th*Math.PI/180 ;
          double x = 1 ; double y = Math.sqrt(4-x*x) ;
          fEllipticalArc(0,0, 2,2, -th, th, FILLED) ;
//          fEnv("psFillGray", 1.0) ;
//         { 
//            double[] xlist = { 0, x,  x} ;
//            double[] ylist = { 0, -y, y} ;
//            fPolygon(xlist, ylist, 3, FILLED) ;
//           }    
                       

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fEllipticalArc(0,0, 2,2, 0, 360, OPEN) ;
          fLine(x,ymin, x,ymax) ;

          th = 35 ; thRad = th*Math.PI/180 ;
          double dth = 10 ;  double dthRad = dth*Math.PI/180 ;
          double r = 2 ;
 
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r,r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.3) ;
          fEllipticalArc(0,0, 0.9*r,0.9*r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, 0.78*r,0.78*r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fEllipticalArc(0,0, 0.63*r,0.63*r, th,th+dth, WEDGE+FILLED) ;
          x= 0.63*r*Math.cos(thRad) ; y= 0.63*r*Math.sin(thRad) ;
          fLine(0,0, x,y) ;
          x= 0.63*r*Math.cos(thRad+dthRad) ; y= 0.63*r*Math.sin(thRad+dthRad) ;
          fLine(0,0, x,y) ;


          fEllipticalArc(0,0, 0.2*r,0.2*r, 0, th, OPEN) ;
          fTeXlabel(0.5, 0.05, "bl", "$\\theta$") ;
          fTeXlabel(1.4, -0.6, "cc", "$R$") ;



          fTeXlabel(1.9, 1, "lc", "$r=2$") ;
          fTeXlabel(1.05, ymin, "bl", "$r\\cos\\theta=1$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          th = 60; x = 1 ; y = Math.sqrt(4-x*x) ;
          fEllipticalArc(0,0, 2,2, -th, th, OPEN) ;
          fLine(x,-y, x,y) ;

          fEnv("psFillGray", 0.0) ;
          r = 0.07 ;
          fDisk(x, y, r, r, FILLED) ;
          fTeXlabel(x+0.1, y+0.1, "cl", "$\\scriptstyle (1,\\sqrt{3}),\\ r=2,\\ \\theta=\\frac{\\pi}{3}$") ;

          
     }
}
