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
      },

      listaSap: null
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
        body: JSON.stringify(this.forms),
      };

      fetch("http://localhost:8080/salvar", options)
        .then(data => alert("Transferência salva com sucesso!"))
        .catch(ex => alert("Ocorreu um erro ao salvar a transferência!"))

      this.pesquisar()
    },

    pesquisar() {
      const options = {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        }
      };

      fetch("http://localhost:8080/pesquisar", options)
        .then(response => response.json())
        .then(data => {
          console.log("Valor retornado:", data)
          this.listaSap = data
        })
        .catch(ex => alert("Ocorreu um erro ao recuperar transferências!"))
    }
  }
}

</script>

<template>
  <main>
    <div class="container mt-5">
      <div class="row">
        <div class="col-5">
          <div class="card">
            <div class="card-header">
              <h2>Agendamento de Tranferências Financeiras </h2>
            </div>
            <div class="card-body">
              <form name="forms" v-on:submit.prevent="salvar">
                <div class="form-row">
                  <div class="form-group col-md-6">
                    <label> Conta de Origem: </label>
                    <input type="text" class="form-control" id="contaOrigem" name="contaOrigem"
                      v-model="forms.contaOrigem" maxLength="6" />
                  </div>
                  <div class="form-group col-md-6">
                    <label>Conta de Destino: </label>
                    <input type="text" id="contaDestino" class="form-control" name="contaDestino"
                      v-model="forms.contaDestino" maxLength="6" />
                  </div>
                </div>
                <div class="row">
                  <div class="form-group col-md-7">
                    <label>Valor da Transferencia: </label>
                    <input type="text" id="valorTrans" name="valorTrans" class="form-control"
                      v-model="forms.valorTrans" />
                  </div>
                  <div class="form-group col-md-5">
                    <label>Taxas: </label>
                    <input type="text" id="taxas" name="taxas" class="form-control" v-model="forms.taxas" />
                  </div>
                </div>
                <div class="row">
                  <div class="form-group col-md-6">
                    <label>Data da Transferencia: </label>
                    <input id="dataTrans" type="date" class="form-control" v-model="forms.dataTrans" />
                  </div>
                  <div class="form-group col-md-6">
                    <label>Data do Agendamento: </label>
                    <input id="dataAgend" type="date" class="form-control" v-model="forms.dataAgend" />
                  </div>
                </div>
                <br>
                <div>
                </div>
                <div class="row">
                  <div class="form-group col-md-6">
                    <button class="btn btn-secondary " type="submit">Limpar</button>
                  </div>
                  <div class="form-group col-md-6">
                    <button type="submit" class="btn btn-success ">Salvar</button>

                  </div>
                </div>

              </form>
            </div>
          </div>
        </div>
        <br>


        <div class="col-7">
          <div class="card">
            <div class="card-header">
              <h2>Tranferências Financeiras Agendadas</h2>
            </div>
            <div class="card-body">
              <table class="table">
                <thead>
                  <tr>
                    <th>Id</th>
                    <th>Conta Origem</th>
                    <th>Conta Destino</th>
                    <th>Valor da Tranferência</th>
                    <th>Data da Transferncia</th>
                    <th>Data do Agendamento</th>
                  </tr>
                </thead>
                <tbody>
                  <tr th:each="tranferencias : ${listaSap}">
                    <td></td>
                  </tr>

                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>


  </main>
</template>

<style scoped></style>
