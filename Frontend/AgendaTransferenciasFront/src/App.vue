<script>
export default {
  name: "App",
  data() {
    return {
      forms: {
        contaOrigem: null,
        contaDestino: null,
        valorTrans: null,
        dataTrans: null,
        dataAgend: null
      }
    }
  },
  methods: {
    salvar() {
      console.log("Entrou na func", this.forms)

      const options = {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(forms),
      };

      fetch("http://localhost:8080/salvar", options)
        .then(data => alert("Transferência salva com sucesso!"))
        .catch(ex => alert("Ocorreu um erro ao salvar a transferência!"))
    }
  }
}

</script>

<template>
  <main>
    <form name="forms" v-on:submit.prevent="salvar">
      <div class="row">       
          <div class="form-group col-md-4">
            <label> Conta de Origem: </label>
            <input type="text" id="contaOrigem" name="contaOrigem" v-model="forms.contaOrigem" />
          </div>
          <div class="form-group col-md-4">
            <label>Conta de Destino: </label>
            <input type="text" id="contaDestino" name="contaDestino" v-model="forms.contaDestino" />
          </div>
          <div  class="form-group col-md-4">
          <label>Valor da Transferencia: </label>
          <input type="text" id="valorTrans" name="valorTrans" v-model="forms.valorTrans" />
        </div>
        
      </div>
      <br><br>
      <div class="row">
        
        <br><br>
        <div class="form-group col-md-4">
          <label>Data da Transferencia: </label>
          <input id="dataTrans" type="date" v-model="forms.dataTrans" />
        </div>
        <br><br>
        <div class="form-group col-md-4">
          <label>Data do Agendamento: </label>
          <input id="dataAgend" type="date" v-model="forms.dataAgend" />
        </div>
        <br><br>
        <div >
          <button>Limpar</button>
          <button type="submit">Salvar</button>
        </div>
      </div>
    </form>


  </main>
</template>

<style scoped>

</style>
