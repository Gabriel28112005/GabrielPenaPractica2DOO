package service;

import java.util.Comparator;
import java.util.Scanner;

import models.*;

import static models.Marca.*;



// FALTA HACER EXEPCIONES PERSONALIZADAS


public class Menu {
    Scanner scanner = new Scanner(System.in);
    boolean salir = false;

    public void mostrarMenu(){
        while (!salir){
            try{
                System.out.print("Gestionamos un catálogo de televisores y móviles. Tenemos las siguientes opciones:\n");
                System.out.print(" 1. Añadir Marca\n");
                System.out.print(" 2. Añadir Televisior\n");
                System.out.print(" 3. Añadir Móvil\n");
                System.out.print(" 4. Buscar Marca\n");
                System.out.print(" 5. Buscar Televisor\n");
                System.out.print(" 6. Buscar Móvil\n");
                System.out.print(" 7. Listar Marcas\n");
                System.out.print(" 8. Listar Artículos\n");
                System.out.print(" 9. Salir\n");
                System.out.print("Sabiendo que no se podrá añadir un televisor o móvil si no se ha registrado anteriormente la marca a la que pertenece, seleccione una opción: ");
                int opcion = scanner.nextInt();

                if(opcion==1){
                    anadirMarca();
                } else if(opcion==2){
                    anadirTelevisor();
                } else if(opcion==3){
                    anadirMovil();
                } else if(opcion==4){
                    buscarMarca();
                } else if(opcion==5){
                    buscarTelevisor();
                } else if(opcion==6){
                    buscarMovil();
                } else if(opcion==7){
                    listarMarcas();
                } else if(opcion==8){
                    listarArticulos();
                } else if(opcion==9){
                    System.out.print("\nSaliendo del programa...\n");
                    salir = true; //Sale del bucle --> Finaliza el programa.9
                } else{
                    System.out.println("Opción no válida. Volviendo al menú...\n");
                }

            }catch(Exception e){
                System.out.print("Error, no ha ingresado un valor válido. Volviendo al menú...\n");
            }
        }







    } //Fin de la función mostrarMenu

    public void anadirMarca(){
        try{
            System.out.print("Ingrese el nombre de la marca: ");
            String nombreMarca = scanner.nextLine().toLowerCase().trim();

            System.out.print("Ingrese el país de la marca: ");
            String paisMarca = scanner.nextLine().toLowerCase().trim();

            scanner.nextLine(); //Se limpia buffer

            System.out.print("Ingrese la facturación de la marca: ");
            int facturacionMarca = scanner.nextInt();
            if(facturacionMarca<0){
                System.out.print("La facturación no puede ser negativa. Volviendo al menú...\n");
                return;
            }

            Marca marca = new Marca(nombreMarca, paisMarca, facturacionMarca);
            listaMarcas.add(marca);
        }catch(Exception e){
            System.out.print("Error, no ha ingresado un valor válido. Volviendo al menú...\n");
        }
    } //Fin de la función anadirMarca





    private void anadirTelevisor(){
        try{
            System.out.print("Ingrese el nombre de la marca del televisor: ");
            String nombreMarcaTelevisor = scanner.nextLine().toLowerCase().trim();



            if(listaMarcas.stream().anyMatch(marca -> marca.getNombre().equals(nombreMarcaTelevisor))){
                System.out.print("Ingrese el precio del televisor: ");
                double precioTelevisor = scanner.nextDouble();
                if(precioTelevisor<0){
                    System.out.print("El precio no puede ser negativo. Volviendo al menú...\n");
                    return;
                }


                System.out.print("Ingrese el nombre del televisor: ");
                String nombreTelevisor = scanner.nextLine().toLowerCase().trim();

                System.out.print("Ingrese el tipo de pantalla del televisor (LED, OLED, QLED): ");
                String pantallaTelevisor = scanner.next().toUpperCase().trim();

                System.out.print("Ingrese el tamaño en pulgadas del televisor: ");
                int tamanoPulgadasTelevisor = scanner.nextInt();
                if(tamanoPulgadasTelevisor<0){
                    System.out.print("El tamaño en pulgadas no puede ser negativo. Volviendo al menú...\n");
                    return;
                }

                TipoPantalla tipoPantallaTelevisor = TipoPantalla.valueOf(pantallaTelevisor);
                Marca marcaTelevisor = listaMarcas.stream()
                        .filter(marca -> marca.getNombre().equals(nombreMarcaTelevisor))
                        .findFirst()
                        .orElse(null);

                Televisor televisor = new Televisor(precioTelevisor, marcaTelevisor, nombreTelevisor, tipoPantallaTelevisor, tamanoPulgadasTelevisor);
                Dispositivo.articulos.add(televisor);

            } else{
                System.out.print("La marca ingresada no está registrada. Volviendo al menú...\n");
            }

        }catch (Exception e){
            System.out.print("Error, no ha ingresado un valor válido. Volviendo al menú...\n");
        }

    } //Fin de la función anadirTelevisor





    private void anadirMovil(){
        try{
            System.out.print("Ingrese el nombre de la marca del móvil: ");
            String nombreMarcaMovil = scanner.nextLine().toLowerCase().trim();

            if(listaMarcas.stream().anyMatch(marca -> marca.getNombre().equals(nombreMarcaMovil))) {
                System.out.print("Ingrese el precio del móvil: ");
                double precioMovil = scanner.nextDouble();
                if(precioMovil<0){
                    System.out.print("El precio no puede ser negativo. Volviendo al menú...\n");
                    return;
                }

                System.out.print("Ingrese el nombre del móvil: ");
                String nombreMovil = scanner.nextLine().toLowerCase().trim();

                System.out.print("Ingrese el sistema operativo del móvil (ANDROID, IOS): ");
                String sistemaOperativoMovil = scanner.nextLine().toUpperCase().trim();

                System.out.print("Ingrese el tamaño de la RAM del móvil (en GB): ");
                int tamanoRamMovil = scanner.nextInt();
                if(tamanoRamMovil<0){
                    System.out.print("El tamaño de la RAM no puede ser negativo. Volviendo al menú...\n");
                    return;
                }

                TipoSistemaOperativo tipoSistemaOperativoMovil = TipoSistemaOperativo.valueOf(sistemaOperativoMovil);

                Marca marcaMovil = listaMarcas.stream()
                        .filter(marca -> marca.getNombre().equals(nombreMarcaMovil))
                        .findFirst()
                        .orElse(null);

                Movil movil = new Movil(precioMovil, marcaMovil, nombreMovil, tipoSistemaOperativoMovil, tamanoRamMovil);

                Dispositivo.articulos.add(movil);

            } else{
                System.out.print("La marca ingresada no está registrada. Volviendo al menú...\n");
            }

        }catch(Exception e){
            System.out.print("Error, no ha ingresado un valor válido. Volviendo al menú...\n");
        }
    } //Fin de la función anadirMovil





    private void buscarMarca(){
        try{
            System.out.print("Ingrese el nombre de la marca a buscar: ");
            String nombreMarcaBuscar = scanner.nextLine().toLowerCase().trim();

            System.out.print("Ingrese el país de la marca: ");
            String paisMarcaBuscar = scanner.nextLine().toLowerCase().trim();


            if(listaMarcas.stream().anyMatch(marca -> marca.getNombre().equals(nombreMarcaBuscar) && marca.getPais().equals(paisMarcaBuscar))){
                Marca marcaBuscada = listaMarcas.stream()
                        .filter(marca -> marca.getNombre().equals(nombreMarcaBuscar) && marca.getPais().equals(paisMarcaBuscar))
                        .findFirst()
                        .orElse(null);
                System.out.print("Marca encontrada:\n" + marcaBuscada + "\n");
            } else{
                System.out.print("La marca ingresada no está registrada. Volviendo al menú...\n");

            }
        }catch(Exception e){
            System.out.print("Error, no ha ingresado un valor válido. Volviendo al menú...\n");
        }





    } //Fin de la función buscarMarca





    private void buscarTelevisor(){
        try{
            System.out.print("Ingrese el precio del televisor a buscar: ");
            double precioTelevisorBuscar = scanner.nextDouble();
            if(precioTelevisorBuscar<0){
                System.out.print("El precio no puede ser negativo. Volviendo al menú...\n");
                return;
            }

            System.out.print("Ingrese el nombre de la marca del televisor a buscar: ");
            Marca marcaTelevisorBuscar = Dispositivo.articulos.stream()
                    .filter(articulo -> articulo instanceof Televisor && ((Televisor) articulo).getPrecio() == precioTelevisorBuscar)
                    .map(articulo -> ((Televisor)articulo).getMarca())
                    .findFirst()
                    .orElse(null);

            System.out.print("Ingrese el nombre del televisor a buscar: ");
            String nombreTelevisorBuscar = scanner.nextLine().toLowerCase().trim();

            System.out.print("Ingrese el tipo de pantalla del televisor a buscar (LED, OLED, QLED): ");
            String pantallaTelevisorBuscar = scanner.next().toUpperCase().trim();
            TipoPantalla tipoPantallaTelevisorBuscar = TipoPantalla.valueOf(pantallaTelevisorBuscar);
            if(!tipoPantallaTelevisorBuscar.equals("LED") && !tipoPantallaTelevisorBuscar.equals("OLED") && !tipoPantallaTelevisorBuscar.equals("QLED")){
                System.out.print("El tipo de pantalla ingresado no es válido. Volviendo al menú...\n");
                return;
            }

            System.out.print("Ingrese el tamaño en pulgadas del televisor a buscar: ");
            int tamanoPulgadasTelevisorBuscar = scanner.nextInt();
            if(tamanoPulgadasTelevisorBuscar<0){
                System.out.print("El tamaño en pulgadas no puede ser negativo. Volviendo al menú...\n");
                return;
            }

            Televisor televisorBuscado = new Televisor(precioTelevisorBuscar, marcaTelevisorBuscar, nombreTelevisorBuscar, tipoPantallaTelevisorBuscar, tamanoPulgadasTelevisorBuscar);

            if(Dispositivo.articulos.contains(televisorBuscado)){
                System.out.print("Televisor encontrado:\n" + televisorBuscado + "\n");
            } else{
                System.out.print("El televisor ingresado no está registrado. Volviendo al menú...\n");
            }

            /*
            * Televisor televisorBuscado = Dispositivo.articulos.stream()
                    .filter(articulo -> articulo instanceof Televisor)
                    .map(articulo -> (Televisor) articulo)
                    .filter(televisor -> televisor.getPrecio() == precioTelevisorBuscar &&
                            televisor.getMarca().equals(marcaTelevisorBuscar) &&
                            televisor.getNombre().equals(nombreTelevisorBuscar) &&
                            televisor.getTipoPantalla() == tipoPantallaTelevisorBuscar &&
                            televisor.getTamanoPulgadas() == tamanoPulgadasTelevisorBuscar)
                    .findFirst()
                    .orElse(null);
            *
            * */

        } catch (Exception e) {
            System.out.print("Error en función buscarTelevisor. Volviendo al menú...\n");
        }

    } //Fin de la función buscarTelevisor





    private void buscarMovil(){
        try{

            System.out.print("Ingrese el precio del móvil a buscar: ");
            double precioMovilBuscar = scanner.nextDouble();
            if(precioMovilBuscar<0){
                System.out.print("El precio no puede ser negativo. Volviendo al menú...\n");
                return;
            }

            System.out.print("Ingrese el nombre de la marca del móvil a buscar: ");
            Marca marcaMovilBuscar = Dispositivo.articulos.stream()
                    .filter(articulo -> articulo instanceof Movil && ((Movil) articulo).getPrecio() == precioMovilBuscar)
                    .map(articulo -> ((Movil)articulo).getMarca())
                    .findFirst()
                    .orElse(null);

            System.out.print("Ingrese el nombre del móvil a buscar: ");
            String nombreMovilBuscar = scanner.nextLine().toLowerCase().trim();

            System.out.print("Ingrese el sistema operativo del móvil a buscar (ANDROID, IOS): ");
            String sistemaOperativoMovilBuscar = scanner.nextLine().toUpperCase().trim();
            TipoSistemaOperativo tipoSistemaOperativoMovilBuscar = TipoSistemaOperativo.valueOf(sistemaOperativoMovilBuscar);
            if(!tipoSistemaOperativoMovilBuscar.equals("ANDROID") && !tipoSistemaOperativoMovilBuscar.equals("IOS")){
                System.out.print("El sistema operativo ingresado no es válido. Volviendo al menú...\n");
                return;
            }

            System.out.print("Ingrese el tamaño de la RAM del móvil a buscar (en GB): ");
            int tamanoRamMovilBuscar = scanner.nextInt();
            if(tamanoRamMovilBuscar<0){
                System.out.print("El tamaño de la RAM no puede ser negativo. Volviendo al menú...\n");
                return;
            }




        } catch (Exception e) {
            System.out.print("Error en función buscarMovil. Volviendo al menú...\n");
        }

    } //Fin de la función buscarMovil





    private void listarMarcas(){
        if(listaMarcas.isEmpty()){
            System.out.print("No hay marcas registradas.\n");
        } else{
            listaMarcas.sort(Comparator.comparing(Marca::getFacturacion).reversed()); //Ordenar listaMarcas por facturación de forma descendente

            //  ¿PARA ORDENARLO PUEDO USAR SORT?

            System.out.print("Listado de marcas registradas:\n");
            listaMarcas.stream().forEach(marca -> System.out.print(marca + "\n"));
        }
    } //Fin de la función listarMarcas





    private void listarArticulos(){
        if(Dispositivo.articulos.isEmpty()){
            System.out.print("No hay artículos registrados.\n");
        } else{
            Dispositivo.articulos.sort(Comparator.comparing(Dispositivo::getPrecio).reversed()); //Ordenar listaArticulos por precio de forma ascendente

            System.out.print("Listado de artículos registrados:\n");
            Dispositivo.articulos.stream().forEach(articulo -> System.out.print(articulo + "\n"));
        }
    } //Fin de la función listarArticulos





} //Fin de la clase Menu