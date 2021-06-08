echo \" Olá, seja bem vindo! \"
echo \" Serei seu ajudante durante sua jornada na Dimension! \"
echo \" Meu nome é André e agora vamos conferir algumas coisas... \"
sleep 4
echo \"Conferindo a versão do Docker\"
docker -v
if [ $? -eq 0 ]; then
    echo \"Docker já instalado.\"
else
    echo \"Docker não instalado\"
    echo \"O Docker te auxiliara na criação de containers, onde cada container agrupara nosso software!\"
    echo \"Gostaria de instalar o Docker? S/n \"
    read inst
    if [ \"$inst\" == \"s\" ]; then
        echo \"Iniciando a instalação do Docker...\"
        sleep 3
        sudo apt update && sudo apt install docker.io -y

        echo \"Instalação completa do Docker\"
        sleep 3
    else
        echo \"Você escolheu não instalar, infelizmente nosso sistema não funcionará, tente fazer o download novamente!\"
        exit
    fi
fi

echo \"Inicializando o Docker\"
sleep 4
sudo systemctl start docker
sudo systemctl enable docker
echo \"Docker foi inicializado\"
sleep 4

echo \"Instalação da imagem MySQL\"
echo \"Verificação se existe a Imagem MySQL\"

if [[ ! "$(sudo docker image inspect mysql:5.7)" ]]; then
    echo \"Imagem MySQL não instalado\"

    echo \"Gostaria de fazer a instalação S/n \"
    read inst
    if [ \"$inst\" == \"s\" ]; then
        echo \"Iniciando a instalação do MySQL...\"
        sleep 2
        sudo docker pull mysql:5.7

        echo \"Instalação completa do MySQL\"
        sleep 2
    else
        echo \"Imagem MySQL já instalado.\"
    fi
fi

echo \"Configurando o ambiente para o MySQL\"
echo \"Conferindo se existe o container MySQL\"

if [[ ! "$(sudo docker ps -aqf "name=ContainerDimensionBD")" ]]; then
    echo \"Container inexistente\"
    echo \"Gostaria de criar o Container? S/n \"
    read inst
    if [ \"$inst\" == \"s\" ]; then
        echo \"Iniciando a criação do ContainerDimensionBD...\"
        sleep 2
        git clone https://github.com/AndreSntos/Dimension
        cd Dimension
        cd mysql
        sudo docker build -t mysql .
        cd ..
        cd ..
        sudo chmod 666 /var/run/docker.sock
        docker run -d -p 3306:3306 --name ContainerDimensionBD -e "MYSQL_DATABASE=dimensionBD" -e "MYSQL_ROOT_PASSWORD=urubu100" mysql

        echo \"Instalação completa do MySQL\"
        sleep 2
    fi
else
    echo \"Container MySQL já existe.\"
    CONTID=$(sudo docker ps -aqf "name=ContainerDimensionBD")
    sudo docker start ${CONTID}
fi

echo \"Instalação de Java\"
sleep 4

echo \"Conferindo a versão do Java\"
javac -version
if [[ ! "$(sudo docker image inspect openjdk:11)" ]]; then
    echo \"Instalação da imagem do Java será iniciado\"
    sudo docker pull openjdk:11

else
    echo \"Imagem Java já foi instalada\"
fi

echo \"Verificação se Container Java existe\"
if [[ ! "$(sudo docker ps -aqf "name=java-jar")" ]]; then
    echo "Não existe o container..."
    sleep 1
    cd Dimension/ApiMysql/target
    chmod 777 DimensionJar.jar
    sudo docker build -t dimensionjava .
    sudo docker run -d --name='java-jar' -t dimensionjava
    sudo docker cp DimensionJar.jar java-jar:/
    sudo docker exec -it java-jar java -jar DimensionJar.jar
else

    CONTID=$(sudo docker ps -aqf "name=java-jar")
    sudo docker stop ${CONTID}
    sudo docker start ${CONTID}
    echo "Container ja existe!"
    cd Dimension/ApiMysql/target
    chmod 777 DimensionJar.jar
    sudo docker build -t dimensionjava .
    sudo docker cp DimensionJar.jar java-jar:/
    sudo docker exec -it java-jar java -jar DimensionJar.jar
fi
# FINALIZAÇÃO DO SCRIPT

echo \"Obrigado por utilizar DimensionScript!\"

echo Script feito por: André Santos e criado por: Dimension
