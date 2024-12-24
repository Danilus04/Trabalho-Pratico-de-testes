package br.edu.utfpr;

public class LeftPad {

    /**
     * Preenche à esquerda uma string com uma string especificada até o tamanho fornecido.
     * 
     * @param str    A string a ser preenchida.
     * @param size   O tamanho máximo da string preenchida.
     * @param padStr A string usada para preenchimento.
     * @return A string preenchida ou a string original se o preenchimento não for necessário.
     */
    public static String leftPad(final String str, final int size, String padStr) {
        // Retorna null se a entrada for null
        if (str == null) {
            return null;
        }

        // Se a string de preenchimento for null ou vazia, use um espaço em branco como padrão
        if (padStr == null || padStr.isEmpty()) {
            padStr = " ";
        }

        // Calcula o número de caracteres de preenchimento necessários
        int paddingLength = size - str.length();

        // Se não for necessário preencher, retorna a string original
        if (paddingLength <= 0) {
            return str;
        }

        // Repete a string de preenchimento até alcançar o tamanho necessário
        StringBuilder padding = new StringBuilder();
        while (padding.length() < paddingLength) {
            padding.append(padStr);
        }

        // Garante que o preenchimento não exceda o tamanho necessário
        padding.setLength(paddingLength);

        // Retorna a string preenchida
        return padding + str;
    }
}
