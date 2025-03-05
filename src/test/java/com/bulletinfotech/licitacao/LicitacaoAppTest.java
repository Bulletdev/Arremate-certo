package com.bulletinfotech.licitacao;

import org.junit.jupiter.api.Test;
import com.bulletinfotech.licitacao.model.Pregao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LicitacaoAppTest {
    @Test
    public void pregaoConstructorShouldInitializeFieldsCorrectly() {
        Pregao pregao = new Pregao("Description", "Open", 1000.0);
        assertEquals("Description", pregao.getDescricao());
        assertEquals("Open", pregao.getSituacao());
        assertEquals(1000.0, pregao.getValorProposto());
    }

    @Test
    public void getDescricaoShouldReturnCorrectDescription() {
        Pregao pregao = new Pregao("Description", "Open", 1000.0);
        assertEquals("Description", pregao.getDescricao());
    }

    @Test
    public void getSituacaoShouldReturnCorrectSituacao() {
        Pregao pregao = new Pregao("Description", "Open", 1000.0);
        assertEquals("Open", pregao.getSituacao());
    }

    @Test
    public void getValorPropostoShouldReturnCorrectValorProposto() {
        Pregao pregao = new Pregao("Description", "Open", 1000.0);
        assertEquals(1000.0, pregao.getValorProposto());
    }

    @Test
    public void setDescricaoShouldUpdateDescricao() {
        Pregao pregao = new Pregao("Description", "Open", 1000.0);
        pregao.setDescricao("New Description");
        assertEquals("New Description", pregao.getDescricao());
    }

    @Test
    public void setSituacaoShouldUpdateSituacao() {
        Pregao pregao = new Pregao("Description", "Open", 1000.0);
        pregao.setSituacao("Closed");
        assertEquals("Closed", pregao.getSituacao());
    }

    @Test
    public void setValorPropostoShouldUpdateValorProposto() {
        Pregao pregao = new Pregao("Description", "Open", 1000.0);
        pregao.setValorProposto(2000.0);
        assertEquals(2000.0, pregao.getValorProposto());
    }
}
