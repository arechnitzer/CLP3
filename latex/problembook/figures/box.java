                  /*  File:  box.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class box extends Template {

     static {templateClass = new box() ; }

     public void setup() {
          filePrefix = "box" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 1.0 ;   // in inches.
          xmin = -20 ;
          xmax = 130 ;
          ymin = -10 ;
          ymax = 65 ;
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
          fEnv("lineWidth", 1.0) ;
          double len = 60 ;
          double ht = 30 ;
          double th = 30 ;
          double costh = Math.cos(th*Math.PI/180) ;
          double sinth = Math.sin(th*Math.PI/180) ;
          {double[] xlist = {0, len, len, 0} ;
           double[] ylist = {0,   0,  ht, ht} ;
           fPolygon(xlist, ylist, 4, CLOSED) ; }
          {double[] xlist = {len, len, len*(1+0.75*costh), len*(1+0.75*costh)} ;
           double[] ylist = {  0,  ht, ht+0.75*len*sinth, 0.75*len*sinth} ;
           fPolygon(xlist, ylist, 4, CLOSED) ; }
          {double[] xlist = {len, len*(1+0.75*costh), len*0.75*costh, 0} ;
           double[] ylist = { ht, ht+0.75*len*sinth, ht+0.75*len*sinth, ht} ;
           fPolygon(xlist, ylist, 4, CLOSED) ; }
           fTeXlabel(len/2, -3, "tc", "$x$") ;
           fTeXlabel(len+0.375*len*costh, 0.375*len*sinth-2, "tl", "$y$") ;
           fTeXlabel(-2, ht/2, "rc", "$z$") ;
           


          
     }
}
