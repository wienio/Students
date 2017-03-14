/**
 * Created by Wienio on 2017-03-08.
 */
public enum StudentType {
    STATIONARY {
        @Override public String toString() {
            return "Stacjonarny";
        }
    },

    NONSTATIONARY {
        @Override public String toString() {
            return "Niestacjonarny";
        }
    },

    POSTGRADUATE {
        @Override public String toString() {
            return "Podyplomowy";
        }
    }
}
