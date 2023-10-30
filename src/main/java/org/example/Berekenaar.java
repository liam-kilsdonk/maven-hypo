package org.example;

public class Berekenaar {

    // variable

    private double eigenInkomen;
    private double partnerInkomen;
    private double totaalInkomen;
    private double maxLeenBedrag;
    private double rente;
    private int termijn;
    private boolean partner;
    private boolean studieSchuld;
    private boolean postcode;
    private double leenBedragMetRente;
    private double aflossingPerMaand;
    private double maandBedrag;
    private double volledigeLoopTijd;



    // get and set

    public void setEigenInkomen(double eigenInkomen) {
        this.eigenInkomen = eigenInkomen;
        this.setTotaalInkomen();
    }

    public double getEigenInkomen() {
        return eigenInkomen;
    }

    public void setPartnerInkomen(double partnerInkomen) {
        this.partnerInkomen = partnerInkomen;
        this.setTotaalInkomen();
    }

    public double getPartnerInkomen() {
        return partnerInkomen;
    }

    public void setTotaalInkomen() {
        this.totaalInkomen = this.getEigenInkomen() + this.getPartnerInkomen();
        this.setMaxLeenBedrag();
    }

    public double getTotaalInkomen() {
        return totaalInkomen;
    }

    public void setMaxLeenBedrag() {
        if (this.getStudieSchuld()) {
            this.maxLeenBedrag = (this.getTotaalInkomen() * 12) * 4.25 * 0.75;
        }
        else {
            this.maxLeenBedrag = (this.getTotaalInkomen() * 12) * 4.25;
        }
    }

    public double getMaxLeenBedrag() {
        return maxLeenBedrag;
    }

    public void setRente(double rente) {
        this.rente = rente;
    }

    public double getRente() {
        return rente;
    }

    public void setTermijn(int termijn) {
        this.termijn = termijn;
    }

    public int getTermijn() {
        return termijn;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }
    public boolean getPartner() {
        return partner;
    }

    public void setStudieSchuld(boolean studieSchuld) {
        this.studieSchuld = studieSchuld;
    }

    public boolean getStudieSchuld() {
        return studieSchuld;
    }

    public void setPostcode(boolean postcode) {
        this.postcode = postcode;
    }
    public boolean getPostcode() {
        return postcode;
    }

    public void setAflossingPerMaand() {
        //this.aflossingPerMaand = aflossingPerMaand;

        this.getLeenBedragMetRente(); // Calculate leenBedragMetRente
        this.aflossingPerMaand = this.getLeenBedragMetRente() / this.getTermijn() / 12;
    }

    public double getAflossingPerMaand() {
        return aflossingPerMaand;
    }

    public double getMaandBedrag() {
        return maandBedrag;
    }

    public void setMaandBedrag(double maandBedrag) {
        this.maandBedrag = maandBedrag;
    }

//    public void setLeenBedragMetRente(double leenBedragMetRente) {
//        this.leenBedragMetRente = this.getMaxLeenBedrag() + (this.getMaxLeenBedrag() * this.getRente());
//    }
//
//    public double getLeenBedragMetRente() {
//        return leenBedragMetRente;
//    }

    public void setLeenBedragMetRente(double v) {
        this.leenBedragMetRente = this.getMaxLeenBedrag() + (this.getMaxLeenBedrag() * this.getRente());
    }

    public double getLeenBedragMetRente() {
        return this.getMaxLeenBedrag() + (this.getMaxLeenBedrag() * this.getRente());
    }

    public double getVolledigeLoopTijd() {
        return volledigeLoopTijd;
    }

    public void setVolledigeLoopTijd(double volledigeLoopTijd) {
        this.volledigeLoopTijd = volledigeLoopTijd;
    }

    // reset values

    public void reset() {
        eigenInkomen = 0.0;
        partnerInkomen = 0.0;
        totaalInkomen = 0.0;
        maxLeenBedrag = 0.0;
        rente = 0.0;
        termijn = 0;
        partner = false;
        studieSchuld = false;
        postcode = false;
        leenBedragMetRente = 0.0;
        aflossingPerMaand = 0.0;
        maandBedrag = 0.0;
        volledigeLoopTijd = 0.0;
    }
}
