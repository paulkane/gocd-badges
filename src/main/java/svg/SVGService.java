package svg;

import gocd.Status;

public class SVGService {

    private static final String BADGE =
        "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"85\" height=\"20\">\n" +
            "    <linearGradient id=\"b\" x2=\"0\" y2=\"100\">\n" +
            "        <stop offset=\"0\" stop-color=\"#bbb\" stop-opacity=\".1\"/>\n" +
            "        <stop offset=\"1\" stop-opacity=\".1\"/>\n" +
            "    </linearGradient>\n" +
            "    <mask id=\"a\">\n" +
            "        <rect width=\"85\" height=\"20\" rx=\"3\" fill=\"#fff\"/>\n" +
            "    </mask>\n" +
            "    <g mask=\"url(#a)\">\n" +
            "        <path fill=\"#ccc\" d=\"M0 0h24v20H0z\"/>\n" +
            "        <path fill=\"%s\" d=\"M24 0h61v20H24z\"/>\n" +
            "        <path fill=\"url(#b)\" d=\"M0 0h85v20H0z\"/>\n" +
            "    </g>\n" +
            "    <g fill=\"#fff\" text-anchor=\"middle\" font-family=\"DejaVu Sans,Verdana,Geneva,sans-serif\" font-size=\"11\">\n" +
            "        <image x=\"5\" y=\"3\" width=\"14\" height=\"14\" xlink:href=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAA5CAYAAACMGIOFAAACeElEQVR4nOyab3HjQAzF5ZsACAQfgzsGhnDHwMfgymCLoGWQMGgZJAxSBgmDlkHqN842ies/K62ltdO+GU2nH2zvb7TW0ypeHI9HunX9SL0AC30JSMJ2DYmGXBV7XH7662xXzZQAckM1XDN2VfwyBwgRE7KkdsDLcOYQQ2JCPtEwJALZzq1ZOsWE7NqqbfFKdebTiwn5QOGQPpD9pS1VQ0zInPiQPqt/LLmuJKiuJdWLlsBiJ9hnVeiTOdWWIQGFr9pajRDSy5EM1NZqIiEhZEWaVZsGYgRICO+ZpPL6ovRfg+1DI0F6FXTuabkBD9YpSiND0mmhoZ2RjdUoQHphsVKrGbeBUISEcuK1gk2rKeRkF1KG9EJhiWkgopSFAmRZdvkvtlJJ5y21ruIwcAtYxYpklvFSxb/TX74Emex611zgI13LtboNhKBB79t2oZUR2YyxmlwTcsjwd4xHxzYQpRZkSKXkqiBtq5kAJFFcA7GZC6RXSbKs9taCqQ2X11X8rmLLvK7XlqYGCb2NfcOpQWLbwVoK5nX9TcJE3kkUnlXAvWdbeAqSNwazsBAnhONNExJBxsyFsIY8GDARZMyxy7HgEkAuA69vi7ipnhFkzCgkfuquDBljDXtKNP7gQBakbQ2JIZ0QbhIjyRBIO2tICCnJnurPBAvNmwcobgoXqJSnkHuqz46qgFCKTB6ozt7W6oHWmXwk2ck/SlaZxGkf2Xs2et6VLDIJsJ+UCBDShET27qr4SwpzG4642zV0sVuqt+eBeX8dMZuBkobN3ZlDDIkJCXW1bTfzKSiE04Gjzx/1pv1+rkfSH2FnpakNl1X0DXkreg8AAP//7nAgfY9ZdpYAAAAASUVORK5CYII=\"/>\n" +
            "        <text x=\"53.5\" y=\"15\" fill=\"#010101\" fill-opacity=\".3\">%s</text>\n" +
            "        <text x=\"53.5\" y=\"14\">%s</text>\n" +
            "    </g>\n" +
            "</svg>";

    public static String getBadge(Status status) {
        return String.format(BADGE, status.getColour(), status.getLabel(), status.getLabel());
    }
}
