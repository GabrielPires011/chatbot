package br.com.alura.ecomart.chatbot.domain.service;

import br.com.alura.ecomart.chatbot.infra.openai.DadosRequisicaoChatCompletion;
import br.com.alura.ecomart.chatbot.infra.openai.OpenAIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    @Autowired
    OpenAIClient openAIClient;

    public String responderPergunta(String pergunta) {
        var promptSistema = "Você é um chatbot de atendimento a clientes de um ecommerce e deve responder apenas perguntas relacionadas com o ecommerce";
        var dados = new DadosRequisicaoChatCompletion(promptSistema, pergunta);
        return openAIClient.enviarRequisicaoChatCompletion(dados);
    }
}
