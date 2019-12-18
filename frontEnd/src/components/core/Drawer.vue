<template>
  <v-navigation-drawer
    id="app-drawer"
    v-model="inputValue"
    app
    dark
    floating
    persistent
    mobile-break-point="991"
    width="260"
  >
    <v-img
      :src="image"
      height="100%"
    >
      <v-layout
        class="fill-height"
        tag="v-list"
        column
      >
        <v-list-tile avatar>
          <v-list-tile-avatar
            color="white"
          >
            <v-img
              :src="logo"
            />
          </v-list-tile-avatar>
          <v-list-tile-title class="title">
            iMeta
          </v-list-tile-title>
        </v-list-tile>
        <v-divider/>
        <v-list-tile
          v-for="(link, i) in links"
          :key="i"
          :to="link.to"
          :active-class="color"
          avatar
          class="v-list-item"
        >
          <v-list-tile-action>
            <v-icon>{{ link.icon }}</v-icon>
          </v-list-tile-action>
          <v-list-tile-title
            v-text="link.text"
          />
        </v-list-tile>
        <v-list-tile
          active-class="success"
          class="v-list-item v-list__tile--buy"
          to="/upgrade"
        >
          <v-list-tile-action>
            <v-icon>mdi-package-up</v-icon>
          </v-list-tile-action>
          <v-list-tile-title class="font-weight-light">
            Sugestões
          </v-list-tile-title>
        </v-list-tile>
      </v-layout>
    </v-img>
  </v-navigation-drawer>
</template>

<script>
// Utilities
import {
  mapMutations,
  mapState
} from 'vuex'

export default {
  props: {
    opened: {
      type: Boolean,
      default: false
    }
  },
  data: () => ({
    logo: 'https://images.vexels.com/media/users/3/157443/isolated/preview/0be262dfa410be573a1e7ea787e76a42---cone-de-cifr--o-de-marketing-by-vexels.png',
    items: [
          {
            action: 'mdi-account',
            title: 'Cliente',
            items: [
              { 
                title: 'Cadastro de Cliente' ,
                name: 'cliente',
                
              },
              {
                name: 'listarCliente',
                title: 'Listar Clientes' 
              },
              
            ],
          },
        ],
    links: [
      {
        to: '/',
        icon: 'mdi-view-dashboard',
        text: 'Metas'
      },
      {
        to: '/user-profile',
        icon: 'mdi-account',
        text: 'Usuário'
      },
      {
        to: '/table-list',
        icon: 'mdi-clipboard-outline',
        text: 'Situação'
      },
      {
        to: '/typography',
        icon: 'mdi-cash',
        text: 'Gastos Mensais'
      },
      {
        to: '/icons',
        icon: 'mdi-chart-bubble',
        text: 'Prioriedades'
      },
      {
        to: '/maps',
        icon: 'mdi-map-marker',
        text: 'Local Atual'
      },
      {
        to: '/notifications',
        icon: 'mdi-bell',
        text: 'Lembretes'
      }
    ]
  }),
  computed: {
    ...mapState('app', ['image', 'color']),
    inputValue: {
      get () {
        return this.$store.state.app.drawer
      },
      set (val) {
        this.setDrawer(val)
      }
    },
    items () {
      return this.$t('Layout.View.items')
    }
  },

  methods: {
    ...mapMutations('app', ['setDrawer', 'toggleDrawer'])
  }
}
</script>

<style lang="scss">
  #app-drawer {
    .v-list__tile {
      border-radius: 4px;

      &--buy {
        margin-top: auto;
        margin-bottom: 17px;
      }
    }
  }
</style>
